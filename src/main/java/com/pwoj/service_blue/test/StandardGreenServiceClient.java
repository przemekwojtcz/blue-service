package com.pwoj.service_blue.test;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StandardGreenServiceClient implements GreenServiceClient{
    @Override
    public GreenServiceResponse test() {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = "http://localhost:8081/test";
        var response
                = restTemplate.getForEntity(url, GreenServiceResponse.class);
        return response.getBody();
    }
}
