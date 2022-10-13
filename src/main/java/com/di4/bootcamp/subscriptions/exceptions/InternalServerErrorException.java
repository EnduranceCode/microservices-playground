package com.di4.bootcamp.subscriptions.exceptions;

import com.di4.bootcamp.subscriptions.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends D4iBootcampException {

    private static final long serialVersionUID = -947009503606847734L;

    public InternalServerErrorException(final String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(final String message, final ErrorDto data) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Collections.singletonList(data));
    }
}
