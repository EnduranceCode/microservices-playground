package com.nttdata.di4.netflixsubscriptions.exceptions;

import com.nttdata.di4.netflixsubscriptions.dto.ErrorDto;
import java.util.Collections;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends NetflixException {

    private static final long serialVersionUID = -947009503606847734L;

    protected InternalServerErrorException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    protected InternalServerErrorException(String message, final ErrorDto data) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Collections.singletonList(data));
    }
}
