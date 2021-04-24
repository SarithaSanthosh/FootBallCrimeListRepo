package com.saritha.football.services.footballcrimelistservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class FootBallMainController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String testMethod()
	{
		return "First Page";
	}

}
