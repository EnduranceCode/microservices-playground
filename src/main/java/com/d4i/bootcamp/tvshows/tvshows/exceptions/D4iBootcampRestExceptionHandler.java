package com.d4i.bootcamp.tvshows.tvshows.exceptions;

import com.d4i.bootcamp.tvshows.tvshows.responses.D4iBootcampResponse;
import com.d4i.bootcamp.tvshows.tvshows.utils.constants.ExceptionConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@SuppressWarnings({"rawtypes", "unchecked"})
public class D4iBootcampRestExceptionHandler {

	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public D4iBootcampResponse unhandledErrors(HttpServletRequest req, Exception ex) {
		return new D4iBootcampResponse(ExceptionConstants.ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
	}

	@ExceptionHandler({D4iBootcampException.class, EmptyResultDataAccessException.class,
			HttpMessageNotReadableException.class})
	@ResponseBody
	public D4iBootcampResponse handleLmException(final HttpServletRequest request,
			final HttpServletResponse response, final D4iBootcampException ex) {
		response.setStatus(ex.getCode());
		return new D4iBootcampResponse(ExceptionConstants.ERROR, String.valueOf(ex.getCode()),
				ex.getMessage(), ex.getErrorList());
	}
}
