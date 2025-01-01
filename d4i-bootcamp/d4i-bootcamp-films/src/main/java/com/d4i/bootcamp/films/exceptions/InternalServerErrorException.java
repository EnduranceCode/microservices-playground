package com.d4i.bootcamp.films.exceptions;

import com.d4i.bootcamp.films.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends D4iBootcampException {

    private static final long serialVersionUID = 1264690552219506536L;

    public InternalServerErrorException(final String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(final String message, final ErrorDto data) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Collections.singletonList(data));
    }
}
