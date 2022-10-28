package com.mastermicroservices.microservices.currencyexchange.controllers;

import com.mastermicroservices.microservices.currencyexchange.dtos.CurrencyExchange;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @GetMapping(path = "/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String fromCurrency,
            @PathVariable String toCurrency) {

        return new CurrencyExchange(1000L, "USD", "INR", BigDecimal.valueOf(50));
    }
}
