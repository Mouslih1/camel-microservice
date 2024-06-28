package com.example.camel_microservice_a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRoute extends RouteBuilder {

    private final DeciderBean deciderBean;


    public MyFileRoute(DeciderBean deciderBean) {
        this.deciderBean = deciderBean;
    }

    @Override
    public void configure() throws Exception
    {
        from("file:files/input")
                .routeId("file-simple-language")
                .transform()
                .body(String.class)
                .choice()
                .when(simple("${file:ext} ends with 'xml'"))
                .log("is XML")
              //  .when(simple("${body} contains 'USD'"))
                .when(method(deciderBean))
                .log("Not XML but contains USD")
                .otherwise()
                .log("Not XML")
                .end()

                .to("direct://log-file-values")
                .to("file:files/output");

        from("direct://log-file-values")

                .log("${messageHistory}  ${file:absolute.path}")
                .log("${file:name} ${file:name.ext} ${file:name.noext} ${file:onlyname}")
                .log("${file:onlyname.noext} ${file:parent} ${file:path} ${file:absolute}")
                .log("${file:size} ${file:modified}")
                .log("${routeId} ${camelId} ${body}");

    }
}
