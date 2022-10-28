package com.mastermicroservices.microservices.currencyexchange.repositories.imp;

import com.mastermicroservices.microservices.currencyexchange.entities.CurrencyExchange;
import com.mastermicroservices.microservices.currencyexchange.repositories.CurrencyExchangeRepository;
import com.mastermicroservices.microservices.currencyexchange.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImp implements CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeServiceImp(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchange getExchangeRate(String currencyFrom, String currencyTo) {

        return currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
    }
}
