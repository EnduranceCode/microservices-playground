package com.d4i.bootcamp.tvshows.exceptions;

import com.d4i.bootcamp.tvshows.dto.ErrorDto;
import java.util.Arrays;
import org.springframework.http.HttpStatus;

public class NotFoundException extends D4iBootcampException {

	private static final long serialVersionUID = -6870732210014274010L;

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(final String message, final ErrorDto data) {
		super(HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}
}
