package com.pwoj.service_blue.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StandardGreenServiceClient implements GreenServiceClient{
    Logger logger = LoggerFactory.getLogger(StandardGreenServiceClient.class);
    @Value(value = "${greenService.baseUrl}")
    private String baseUrl;
    @Override
    public GreenServiceResponse test() {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = baseUrl +"/test";
        logger.info("Green service url: " + url);
        var response
                = restTemplate.getForEntity(url, GreenServiceResponse.class);
        return response.getBody();
    }
}
