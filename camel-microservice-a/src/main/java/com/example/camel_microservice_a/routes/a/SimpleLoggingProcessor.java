package com.example.camel_microservice_a.routes.a;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessing.class);

    @Override
    public void process(Exchange exchange) throws Exception
    {
        logger.info("SimpleLoggingProcessor {}", exchange.getMessage().getBody());
    }
}
