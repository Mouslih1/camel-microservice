package com.example.camel_microservice_b.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception
    {
        from("activemq:my-active-mq-queue")
                .to("log:received-message-from-active-mq");
    }
}
