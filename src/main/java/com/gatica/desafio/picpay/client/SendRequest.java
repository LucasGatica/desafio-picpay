package com.gatica.desafio.picpay.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendRequest {
    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> sendRequest(String url){
       return restTemplate.getForEntity(url,String.class);
    }


}
