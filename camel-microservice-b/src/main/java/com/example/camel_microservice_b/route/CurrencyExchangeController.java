package com.example.camel_microservice_b.route;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getConversionValue(
            @PathVariable String from,
            @PathVariable String to
    )
    {
        return new CurrencyExchange(1111L, from, to, BigDecimal.TEN);
    }
}
