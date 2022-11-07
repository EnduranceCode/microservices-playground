package com.mastermicroservices.microservices.currencyconversion.controller;

import com.mastermicroservices.microservices.currencyconversion.dtos.CurrencyConversion;
import com.mastermicroservices.microservices.currencyconversion.responses.BaseResponse;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    private static final String SUCCESS = "Success";
    private static final String OK = "OK";

    private final Environment environment;

    @Autowired
    public CurrencyConversionController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(
            path = "/currency-conversion/from/{currencyFrom}/to/{currencyTo}/quantity/{quantity}")
    public BaseResponse<CurrencyConversion> calculateCurrencyConversion(
            @PathVariable String currencyFrom, @PathVariable String currencyTo,
            @PathVariable Integer quantity) {

        return new BaseResponse<>(SUCCESS, String.valueOf(HttpStatus.OK), OK,
                new CurrencyConversion(10001L, "USD", "INR", BigDecimal.valueOf(quantity),
                        BigDecimal.valueOf(65), BigDecimal.valueOf(650),
                        environment.getProperty("local.server.port")));
    }
}
