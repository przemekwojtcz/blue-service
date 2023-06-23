package com.pwoj.service_blue.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final GreenServiceClient greenServiceClient;

    public TestController(GreenServiceClient greenServiceClient) {
        this.greenServiceClient = greenServiceClient;
    }


    @GetMapping("/test")
    TestResponse test() {
        logger.info("Receive request to service green");
        var result = greenServiceClient.test();
        logger.info("Retrieve result from service green");
        return new TestResponse("Service blue and "+result.value());
    }
}
