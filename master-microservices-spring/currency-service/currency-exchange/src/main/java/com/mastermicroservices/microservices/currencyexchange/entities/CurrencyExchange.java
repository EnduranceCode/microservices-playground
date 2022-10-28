package com.mastermicroservices.microservices.currencyexchange.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CurrencyExchange")
@Table(name = "currency_exchange")
public class CurrencyExchange {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String currencyFrom;

    @Column(name = "currency_to")
    private String currencyTo;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name = "environment")
    private String environment;

    public CurrencyExchange() {
        super();
    }

    public CurrencyExchange(Long id, String currencyFrom, String currencyTo,
            BigDecimal conversionMultiple, String environment) {
        super();
        this.id = id;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.conversionMultiple = conversionMultiple;
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

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
