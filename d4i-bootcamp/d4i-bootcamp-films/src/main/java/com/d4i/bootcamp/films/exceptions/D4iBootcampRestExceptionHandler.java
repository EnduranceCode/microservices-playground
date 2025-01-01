package com.d4i.bootcamp.films.exceptions;

import com.d4i.bootcamp.films.responses.D4iBootcampResponse;
import com.d4i.bootcamp.films.utils.constants.ExceptionConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@SuppressWarnings({"rawtypes", "unchecked"})
public class D4iBootcampRestExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public D4iBootcampResponse unhandledErrors(HttpServletRequest request, Exception exception) {

        return new D4iBootcampResponse(ExceptionConstants.ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage());
    }

    @ResponseBody
    @SuppressWarnings("unused")
    @ExceptionHandler({D4iBootcampException.class})
    public D4iBootcampResponse handledException(final HttpServletRequest request,
            final HttpServletResponse response, final D4iBootcampException exception) {

        return new D4iBootcampResponse(ExceptionConstants.ERROR,
                String.valueOf(exception.getCode()), exception.getMessage(),
                exception.getErrorList());
    }
}
