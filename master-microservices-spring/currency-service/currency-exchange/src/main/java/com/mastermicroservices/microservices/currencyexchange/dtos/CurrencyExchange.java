package com.mastermicroservices.microservices.currencyexchange.dtos;

import java.math.BigDecimal;

public class CurrencyExchange {

    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;

    public CurrencyExchange() {
        super();
    }

    public CurrencyExchange(Long id, String fromCurrency, String toCurrency,
            BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
