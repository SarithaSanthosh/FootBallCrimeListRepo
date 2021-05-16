package com.saritha.football.services.footballcrimelistservices.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saritha.football.services.footballcrimelistservices.client.APIClient;
import com.saritha.football.services.footballcrimelistservices.model.crime.Crime;
import com.saritha.football.services.footballcrimelistservices.model.footballcrimeresponse.FootBallCrimeData;
import com.saritha.football.services.footballcrimelistservices.model.location.Location;
import com.saritha.football.services.footballcrimelistservices.model.stadium.StadiumResponse;
import com.saritha.football.services.footballcrimelistservices.model.stadium.Team;


@Service
public class FootBallCrimeService {
	
    @Autowired
    APIClient apiClient;
    Logger logger = LoggerFactory.getLogger(FootBallCrimeService.class);
	//get Team details
	
	
	public  List<FootBallCrimeData> getCrimeData() throws JsonMappingException, JsonProcessingException {
		
		  Map<String,String> queryMap=new HashMap<>();
	        //-request GET 'http://api.football-data.org/v2/competitions/PL/teams?id=2021' \
	        queryMap.put("id","2021");
	        StadiumResponse     response   =apiClient.callGet("http://api.football-data.org/v2/competitions/PL/teams",
	                "058faff9c3a74b5f8c224a5586272fce", StadiumResponse.class,queryMap);
	       //logger.info(response.toString());
	        
	      System.out.println(response);
	       List<FootBallCrimeData> footBallCrimeDataList = new ArrayList<FootBallCrimeData>();
	        
	        for( Team team : response.getTeams())
	        {
	        	String address= team.getAddress();
	        	String[] postCodeArray = address.split("\\s");
	        	String postcode = postCodeArray[postCodeArray.length-2]+" " + postCodeArray[postCodeArray.length-1];
	        	System.out.println(address);
	        	System.out.println(postcode);
	        	
	        	  
	        	//LocalDate.now().getYear()

	               Location locResponse   =apiClient.callGet("http://api.postcodes.io/postcodes/"+postcode,
	                       Location.class);
	               System.out.println(locResponse.getResult().getLatitude());
	              // String latitude = locResponse.getResult().getLatitude();
	               
	               
	               Map<String,String> queryMap1=new HashMap<>();
	               
	               
	               for (int i=1;i<4;i++) {
	            	   String format = String.format("%%0%dd", 2);
	            	   String month = String.format(format, i);
	            	   System.out.println("*******" + month);
		               queryMap1.put("date","2021-"+month);
		               queryMap1.put("lat",(""+locResponse.getResult().getLatitude()));
		               queryMap1.put("lng",(""+locResponse.getResult().getLongitude()));
		               String     crimeResponse   =apiClient.callGet("https://data.police.uk/api/crimes-at-location",
		                       String.class,queryMap1);
		               System.out.println(crimeResponse);
		               List<Crime> participantJsonList = new ObjectMapper().readValue(crimeResponse, new TypeReference<List<Crime>>(){});
		            
		              // logger.info(participantJsonList.get(0).getCategory());
		               List<FootBallCrimeData> crimeDatas = generateCrimeDataResponse(team.getName(), team.getAddress(),participantJsonList);
		               
		               footBallCrimeDataList.addAll(crimeDatas);
	               }
	               
	        }
	        
	       footBallCrimeDataList = footBallCrimeDataList.stream().sorted(Comparator.comparing(FootBallCrimeData::getMonth)).collect(Collectors.toList());
	       return  footBallCrimeDataList;
	        
	}
	
	public List<FootBallCrimeData> generateCrimeDataResponse(String teamName, String address, List<Crime> crimeList) {
		
		List<FootBallCrimeData> crimeDatas = new ArrayList<FootBallCrimeData>();
		
		for (Crime crime : crimeList) {
			FootBallCrimeData footBallCrimeDate  = new FootBallCrimeData();
			footBallCrimeDate.setAddress(address);
			footBallCrimeDate.setName(teamName);
			footBallCrimeDate.setCategory(crime.getCategory());
			LocalDate date=YearMonth.parse(crime.getMonth()).atDay(1);
			footBallCrimeDate.setMonth(date);
			crimeDatas.add(footBallCrimeDate);
		}
		
		return crimeDatas;
		
	}

}
