package com.example.camel_microservice_a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EipPatternsRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception
    {
        from("timer:multicast?period=10000")
                .multicast()
                .to("log:some1", "log:some2", "log:some3");

    }
}
