package com.saritha.football.services.footballcrimelistservices.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.saritha.football.services.footballcrimelistservices.model.footballcrimeresponse.FootBallCrimeData;

import junit.framework.Assert;

@SpringBootTest
public class FootBallCrimeServiceTest {
	
	@Autowired
	FootBallCrimeService footBallCrimeService;
	@Test
	public void getCrimeData() {
		
		try {
			List<FootBallCrimeData> crimeData = footBallCrimeService.getCrimeData();
			System.out.println(crimeData);
			Assert.assertNotNull("CrimeData Cannot be Null", crimeData);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
