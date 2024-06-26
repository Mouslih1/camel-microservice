package com.example.camel_microservice_a.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class MyFirstTimerRoute extends RouteBuilder {

    private final GetCurrentTimer getCurrentTimer;
    private final SimpleLoggingProcessing simpleLoggingProcessing;

    public MyFirstTimerRoute(GetCurrentTimer getCurrentTimer,
                             SimpleLoggingProcessing simpleLoggingProcessing1
    )
    {
        this.getCurrentTimer = getCurrentTimer;
        this.simpleLoggingProcessing = simpleLoggingProcessing1;
    }

    @Override
    public void configure() throws Exception
    {
        from("timer:first-timer")
                .log("${body}")
                .transform()
                .constant("My Constant Message")
                .log("${body}")
                //.constant("Date now is : " + LocalDateTime.now())
                .bean(getCurrentTimer, "getTimer")
                .log("${body}")
                .process(new SimpleLoggingProcessor())
                .log("${body}")
                .to("log:first-timer");
    }
}

