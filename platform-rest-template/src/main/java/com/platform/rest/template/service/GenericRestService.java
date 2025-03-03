package com.platform.rest.template.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericRestService {


    private final RestTemplate restTemplate;
    public GenericRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getResponse(){
        restTemplate.getForObject("http://platform-cloud/rest/template/generic", String.class);
    }
}
