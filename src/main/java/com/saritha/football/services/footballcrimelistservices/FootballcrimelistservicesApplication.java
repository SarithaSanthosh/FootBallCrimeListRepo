package com.saritha.football.services.footballcrimelistservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FootballcrimelistservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballcrimelistservicesApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder){
		RestTemplate restTemplate= builder.build();
		return restTemplate;
	}

}
