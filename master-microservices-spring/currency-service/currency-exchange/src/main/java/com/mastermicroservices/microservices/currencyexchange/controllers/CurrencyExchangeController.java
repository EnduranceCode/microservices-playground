package com.mastermicroservices.microservices.currencyexchange.controllers;

import com.mastermicroservices.microservices.currencyexchange.entities.CurrencyExchange;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;

    @Autowired
    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(path = "/currency-exchange/from/{currencyFrom}/to/{toCurrency}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String currencyFrom,
            @PathVariable String currencyTo) {

        return new CurrencyExchange(1000L, "USD", "INR", BigDecimal.valueOf(50),
                environment.getProperty("local.server.port"));
    }
}
