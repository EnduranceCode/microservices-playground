package com.mastermicroservices.microservices.currencyexchange.exceptions;

public class BaseException extends Exception {

    private static final long serialVersionUID = -2663415328624224597L;

    private final int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
