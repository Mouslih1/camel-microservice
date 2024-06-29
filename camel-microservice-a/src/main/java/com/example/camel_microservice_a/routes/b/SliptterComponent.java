package com.example.camel_microservice_a.routes.b;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SliptterComponent {

    public List<String> splitInput(String body)
    {
        return List.of("ABC","DEF", "GHI");
    }
}
