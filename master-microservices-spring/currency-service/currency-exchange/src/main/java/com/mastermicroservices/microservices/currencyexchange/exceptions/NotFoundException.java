package com.mastermicroservices.microservices.currencyexchange.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

    private static final long serialVersionUID = -9126856980012940672L;

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
