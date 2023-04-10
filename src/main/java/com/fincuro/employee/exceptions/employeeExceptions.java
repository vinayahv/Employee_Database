package com.fincuro.employee.exceptions;
import lombok.Data;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Data


public class employeeExceptions {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;


    public employeeExceptions(String message, Throwable throwable, HttpStatus httpStatus) {
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
