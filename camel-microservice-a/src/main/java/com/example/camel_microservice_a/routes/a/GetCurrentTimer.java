package com.example.camel_microservice_a.routes.a;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimer {

    public String getTimer()
    {
        return "Date now is : " + LocalDateTime.now();
    }
}
