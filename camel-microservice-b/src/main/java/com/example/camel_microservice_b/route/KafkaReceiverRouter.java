package com.example.camel_microservice_b.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiverRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception
    {
        from("kafka:myKafkaJsonTopic")
                .to("log:received-message-from-kafka");

    }
}
