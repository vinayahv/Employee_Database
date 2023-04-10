package com.fincuro.employee.exceptions;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data


public class EemployeeExceptions {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;


    public EemployeeExceptions(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


}
