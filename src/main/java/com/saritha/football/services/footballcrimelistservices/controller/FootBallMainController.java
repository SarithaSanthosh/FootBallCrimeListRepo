package com.saritha.football.services.footballcrimelistservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.saritha.football.services.footballcrimelistservices.model.footballcrimeresponse.FootBallCrimeData;
import com.saritha.football.services.footballcrimelistservices.service.FootBallCrimeService;

@RestController
public class FootBallMainController {
	
	@Autowired
	FootBallCrimeService footBallCrimeService;
	@RequestMapping(method = RequestMethod.GET, value = "/getCrimeRecords")
	
	public List<FootBallCrimeData> getCrimeRecords()
	{
		try {
			return footBallCrimeService.getCrimeData();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
