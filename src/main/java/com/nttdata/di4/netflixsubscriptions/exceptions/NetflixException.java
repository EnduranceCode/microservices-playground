package com.nttdata.di4.netflixsubscriptions.exceptions;

import com.nttdata.di4.netflixsubscriptions.dto.ErrorDto;
import java.util.ArrayList;
import java.util.List;

public abstract class NetflixException extends Exception {

    private static final long serialVersionUID = -416578427680351802L;

    private final int code;

    private final List<ErrorDto> errorList = new ArrayList<>();

    protected NetflixException(final int code, final String message) {
        super(message);
        this.code = code;
    }

    protected NetflixException(int code, final String message, final List<ErrorDto> errorList) {
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
