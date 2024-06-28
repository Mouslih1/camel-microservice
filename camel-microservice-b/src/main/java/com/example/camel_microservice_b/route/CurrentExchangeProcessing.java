package com.example.camel_microservice_b.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CurrentExchangeProcessing {

    Logger logger = LoggerFactory.getLogger(CurrentExchangeProcessing.class);

    public void processMessage(CurrencyExchange currencyExchange)
    {
        logger.info("Do some processing currencyExchange.getConversionMultiple() {}", currencyExchange.getConversionMultiple());
    }
}
