package com.mastermicroservices.microservices.currencyexchange.controllers;

import com.mastermicroservices.microservices.currencyexchange.entities.CurrencyExchange;
import com.mastermicroservices.microservices.currencyexchange.exceptions.NotFoundException;
import com.mastermicroservices.microservices.currencyexchange.responses.BaseResponse;
import com.mastermicroservices.microservices.currencyexchange.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private static final String SUCCESS = "Success";
    private static final String OK = "OK";

    private final Environment environment;

    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyExchangeController(Environment environment,
            CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService = currencyExchangeService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/currency-exchange/from/{currencyFrom}/to/{currencyTo}")
    public BaseResponse<CurrencyExchange> retrieveExchangeRate(@PathVariable String currencyFrom,
            @PathVariable String currencyTo) throws NotFoundException {

        CurrencyExchange exchangeRate =
                currencyExchangeService.getExchangeRate(currencyFrom, currencyTo);

        if (exchangeRate == null) {
            throw new NotFoundException(
                    String.format("Unable to find data for %s to %s", currencyFrom, currencyTo));
        }

        exchangeRate.setEnvironment(environment.getProperty("local.server.port"));

        return new BaseResponse<>(SUCCESS, String.valueOf(HttpStatus.OK), OK, exchangeRate);
    }
}
