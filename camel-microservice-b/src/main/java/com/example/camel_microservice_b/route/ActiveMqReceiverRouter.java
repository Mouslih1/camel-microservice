package com.example.camel_microservice_b.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception
    {
     /*
     Receive queue and marshal it in Json

        from("activemq:my-active-mq-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(new CurrentExchangeProcessing())
                .bean(new CurrentExchangeTransformer())
                .to("log:received-message-from-active-mq");
      */

       /* from("activemq:active-mq-xml-queue")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)
             //   .bean(new CurrentExchangeProcessing())
                .bean(new CurrentExchangeTransformer())
                .to("log:received-message-from-active-mq");*/

        from("activemq:active-split-queue")
                .to("log:log:received-message-from-active-mq");
    }
}
