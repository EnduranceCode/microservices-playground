package com.di4.bootcamp.subscriptions.exceptions;

import com.di4.bootcamp.subscriptions.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class BadRequestException extends D4iBootcampException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }

    public BadRequestException(String message, ErrorDto data) {
        super(HttpStatus.BAD_REQUEST.value(), message, Collections.singletonList(data));
    }
}
