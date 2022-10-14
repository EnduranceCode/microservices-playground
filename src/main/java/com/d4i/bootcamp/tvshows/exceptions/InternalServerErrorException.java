package com.d4i.bootcamp.tvshows.exceptions;

import com.d4i.bootcamp.tvshows.dto.ErrorDto;
import java.util.Arrays;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends D4iBootcampException {

	private static final long serialVersionUID = -6870732210014274010L;

	public InternalServerErrorException(final String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public InternalServerErrorException(final String message, final ErrorDto data) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}
