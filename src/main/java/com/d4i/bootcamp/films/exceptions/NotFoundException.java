package com.d4i.bootcamp.films.exceptions;

import com.d4i.bootcamp.films.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class NotFoundException extends D4iBootcampException {

    private static final long serialVersionUID = -5771220719001568396L;

    public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(final String message, final ErrorDto data) {
        super(HttpStatus.NOT_FOUND.value(), message, Collections.singletonList(data));
    }
}
