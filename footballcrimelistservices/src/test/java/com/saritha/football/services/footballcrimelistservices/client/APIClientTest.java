package com.saritha.football.services.footballcrimelistservices.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saritha.football.services.footballcrimelistservices.model.crime.Crime;
import com.saritha.football.services.footballcrimelistservices.model.location.Location;
import com.saritha.football.services.footballcrimelistservices.model.stadium.StadiumResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class APIClientTest {
    @Autowired
    APIClient apiClient;
    Logger logger = LoggerFactory.getLogger(APIClientTest.class);


    @Test
    public void testCallGetWithHeaders(){
        Map<String,String> queryMap=new HashMap<>();
        //-request GET 'http://api.football-data.org/v2/competitions/PL/teams?id=2021' \
        queryMap.put("id","2021");
        StadiumResponse     response   =apiClient.callGet("http://api.football-data.org/v2/competitions/PL/teams",
                "058faff9c3a74b5f8c224a5586272fce", StadiumResponse.class,queryMap);
        logger.info(response.toString());
        Assert.notNull(response,"Response Cannot be Null");


    }

    @Test
    public void testCallGetPostCode(){
        //request GET 'http://api.postcodes.io/postcodes/N5 1BU' \
        Map<String,String> queryMap=new HashMap<>();

        Location     response   =apiClient.callGet("http://api.postcodes.io/postcodes/N5 1BU",
                Location.class,queryMap);
        logger.info(response.toString());

        Assert.notNull(response,"Response Cannot be Null");

    }

    @Test
    public void testCallGetCrime() throws JsonProcessingException {
        Map<String,String> queryMap=new HashMap<>();
        queryMap.put("date","2021-02");
        queryMap.put("lat","52.629729");
        queryMap.put("lng","-1.131592");
        String     response   =apiClient.callGet("https://data.police.uk/api/crimes-at-location",
                String.class,queryMap);
        List<Crime> participantJsonList = new ObjectMapper().readValue(response, new TypeReference<List<Crime>>(){});
        logger.info(response.toString());
        logger.info(participantJsonList.get(0).getCategory());

        Assert.notNull(response,"Response Cannot be Null");

    }
}
