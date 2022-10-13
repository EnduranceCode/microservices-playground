package com.di4.bootcamp.subscriptions.exceptions;

import com.di4.bootcamp.subscriptions.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class NotFoundException extends D4iBootcampException {

    private static final long serialVersionUID = -7399444852063737770L;

    protected NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

    protected NotFoundException(String message, final ErrorDto data) {
        super(HttpStatus.NOT_FOUND.value(), message, Collections.singletonList(data));
    }
}
