package com.saritha.football.services.footballcrimelistservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Iterator;
import java.util.Map;

@Component
public class APIClient {

    private RestTemplate restTemplate;

    @Autowired
    public APIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T callGet(String baseUrl,Class<T> returnType){
        UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(baseUrl);
        System.out.println(builder.build().toUri());
        return restTemplate.getForObject(builder.build().toUri(),returnType);
    }

    public <T> T callGet(String url,  String apikey, Class<T> returnType, Map<String,String> queryParameters){
        UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(url);
        Iterator<Map.Entry<String, String>> entryIterator=queryParameters.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            builder=builder.queryParam(entry.getKey(),entry.getValue());
        }
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("X-Auth-Token",apikey);
        HttpEntity httpEntity=new HttpEntity(httpHeaders);
        System.out.println(builder.build().toUri());
        //
        ResponseEntity<T> responseEntity= restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,httpEntity,returnType);
        if(responseEntity.getStatusCode()== HttpStatus.OK){
            return responseEntity.getBody();
        }
        return null;
    }

    public <T> T callGet(String baseUrl,  Class<T> returnType, Map<String,String> queryParameters){
        UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(baseUrl);
        Iterator<Map.Entry<String, String>> entryIterator=queryParameters.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            builder=builder.queryParam(entry.getKey(),entry.getValue());
        }
        System.out.println(builder.build().toUri());
        //
        return  restTemplate.getForObject(builder.build().toUri(),returnType);

    }
}
