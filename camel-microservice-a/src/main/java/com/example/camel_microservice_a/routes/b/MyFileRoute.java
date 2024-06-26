package com.example.camel_microservice_a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception
    {
        from("file:files/input")
                .to("file:files/output");

    }
}
