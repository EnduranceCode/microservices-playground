package com.d4i.bootcamp.films.exceptions;

import com.d4i.bootcamp.films.dto.ErrorDto;
import java.util.ArrayList;
import java.util.List;

public class D4iBootcampException extends Exception {

    private static final long serialVersionUID = -4954691748315252380L;

    private final int code;

    private final List<ErrorDto> errorList = new ArrayList<>();

    public D4iBootcampException(int code, String message) {
        super(message);
        this.code = code;
    }

    protected D4iBootcampException(int code, final String message, final List<ErrorDto> errorList) {
        super(message);
        this.code = code;
        this.errorList.addAll(errorList);
    }

    public int getCode() {
        return code;
    }

    public List<ErrorDto> getErrorList() {
        return errorList;
    }
}
