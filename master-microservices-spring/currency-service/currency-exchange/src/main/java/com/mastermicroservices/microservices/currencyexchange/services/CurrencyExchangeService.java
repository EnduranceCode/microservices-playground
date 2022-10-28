package com.mastermicroservices.microservices.currencyexchange.services;

import com.mastermicroservices.microservices.currencyexchange.entities.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getExchangeRate(String currencyFrom, String currencyTo);
}
