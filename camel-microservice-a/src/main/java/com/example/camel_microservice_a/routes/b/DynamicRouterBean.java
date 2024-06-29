package com.example.camel_microservice_a.routes.b;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DynamicRouterBean {

    Logger logger = LoggerFactory.getLogger(DynamicRouterBean.class);

    int counter;

    public String decideTheNextEnPoint(
            @ExchangeProperties Map<String, String> properties,
            @Headers Map<String, String> headers,
            @Body String body
            )
    {
        logger.info("salam {} {} {}", properties, headers, body);
        counter++;

        if(counter % 3 == 0)
            return "direct:endpoint1";
        if(counter % 3 == 1)
            return "direct:endpoint2, direct:endpoint3";
        return null;
    }
}
