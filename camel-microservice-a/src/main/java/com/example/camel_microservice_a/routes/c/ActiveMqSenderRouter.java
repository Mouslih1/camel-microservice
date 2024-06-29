package com.example.camel_microservice_a.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception
    {
        /*
        Send Simple message with timer to queue

        from("timer:active-mq-timer?period=10000")
                .transform()
                .constant("My Message ActiveMq")
                .to("activemq:my-active-mq-queue");
         */

        /*
        Send Json to queue

        from("file:files/json")
                .log("${body}")
                .to("activemq:my-active-mq-queue");
         */

        from("file:files/xml")
                .log("${body}")
                .to("activemq:active-mq-xml-queue");
    }
}
