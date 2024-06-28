package com.example.camel_microservice_b.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrentExchangeTransformer {

    public void processMessage(CurrencyExchange currencyExchange)
    {
        currencyExchange.setConversionMultiple(
                currencyExchange.
                        getConversionMultiple().
                        multiply(BigDecimal.TEN)
        );
    }
}
