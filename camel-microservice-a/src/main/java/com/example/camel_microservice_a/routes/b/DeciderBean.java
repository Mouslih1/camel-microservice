package com.example.camel_microservice_a.routes.b;

import org.apache.camel.Body;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeciderBean {

    Logger logger = LoggerFactory.getLogger(DeciderBean.class);

    public boolean isThisConditionMet(
            @Body String body,
            @Headers Map<String, String> headers
    )
    {
        logger.info("isThisConditionMet {} {}", body, headers);
        return true;
    }
}
