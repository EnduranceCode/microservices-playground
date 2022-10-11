package com.nttdata.di4.netflixsubscriptions.exceptions;

import com.nttdata.di4.netflixsubscriptions.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class NotFoundException extends NetflixException {

    private static final long serialVersionUID = -7399444852063737770L;

    protected NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

    protected NotFoundException(String message, final ErrorDto data) {
        super(HttpStatus.NOT_FOUND.value(), message, Collections.singletonList(data));
    }
}
