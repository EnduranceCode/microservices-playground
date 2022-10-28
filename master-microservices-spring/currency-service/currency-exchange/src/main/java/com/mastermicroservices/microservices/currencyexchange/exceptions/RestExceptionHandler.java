package com.mastermicroservices.microservices.currencyexchange.exceptions;

import com.mastermicroservices.microservices.currencyexchange.responses.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler<T> {

    private static final String ERROR = "ERROR";

    @ResponseBody
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<T> unhandledError(HttpServletRequest request, Exception exception) {

        return new BaseResponse<>(ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({BaseException.class})
    public BaseResponse<T> handledException(HttpServletRequest request, Exception exception) {

        return new BaseResponse<>(ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage());
    }
}
