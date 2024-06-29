package com.example.camel_microservice_a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class EipPatternsRouter extends RouteBuilder {

    private final SliptterComponent sliptterComponent;
    private final DynamicRouterBean dynamicRouterBean;

    public EipPatternsRouter(SliptterComponent sliptterComponent, DynamicRouterBean dynamicRouterBean)
    {
        this.sliptterComponent = sliptterComponent;
        this.dynamicRouterBean = dynamicRouterBean;
    }

    @Override
    public void configure() throws Exception
    {
        /*
        Pipeline()
        Content based routing  - choice()
        Multicast
         */
       /*
       from("timer:multicast?period=10000")
                .multicast()
                .to("log:some1", "log:some2", "log:some3");
               */

    /*    from("file:files/csv")
                .unmarshal().csv()
                .split(body())
                .to("log:split-log");*/

  /*      from("file:files/csv")
                .unmarshal().csv()
                .split(body())
                .to("activemq:active-split-queue");*/

//        from("file:files/csv")
//                //.convertBodyTo(String.class)
//                .split(method(sliptterComponent))
//                .to("activemq:active-split-queue");

        /**
         * Aggregation
         * message : aggregation : endpoint
         * to : 3
         */
        from("file:files/aggregate-json")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .aggregate(simple("${body.to}"), new ArrayListAggregationStrategy())
                .completionSize(3)
                .to("log:aggregation-log-json");


        /**
         * Routing split patterns
         */
       // String routingSplit = "direct:endpoint1, direct:endpoint2, direct:endpoint3";

//        from("timer:routeSplit?period=10000")
//                .transform().constant("my message split")
//                .routingSlip(simple(routingSplit));

        from("direct:endpoint1")
                .to("log:directendpoint1");

        from("direct:endpoint2")
                .to("log:directendpoint2");

        from("direct:endpoint3")
                .to("log:directendpoint3");


        /**
         * Dynamic routing
         */

        from("timer:dynamicRouting?period=10000")
                .transform().constant("my message split")
                .dynamicRouter(method(dynamicRouterBean));
    }
}
