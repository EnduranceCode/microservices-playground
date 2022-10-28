package com.mastermicroservices.microservices.currencyexchange.repositories;

import com.mastermicroservices.microservices.currencyexchange.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
