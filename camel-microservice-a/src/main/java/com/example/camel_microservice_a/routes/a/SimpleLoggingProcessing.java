package com.example.camel_microservice_a.routes.a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessing {

    private final Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessing.class);

    public void process(String message)
    {
        logger.info("SimpleLoggingProcessing {}", message);
    }
}
