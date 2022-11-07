package com.mastermicroservices.microservices.currencyconversion.dtos;

import java.math.BigDecimal;

public class CurrencyConversion {

    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal quantity;
    private BigDecimal exchangeRate;
    private BigDecimal totalCalculatedAmount;
    private String environment;

    public CurrencyConversion() {
        super();
    }

    public CurrencyConversion(Long id, String currencyFrom, String currencyTo, BigDecimal quantity,
            BigDecimal exchangeRate, BigDecimal totalCalculatedAmount, String environment) {
        super();
        this.id = id;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.quantity = quantity;
        this.exchangeRate = exchangeRate;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
