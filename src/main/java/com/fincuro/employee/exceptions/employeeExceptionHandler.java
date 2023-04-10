package com.fincuro.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class employeeExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        employeeExceptions employeeExceptions=new employeeExceptions(
                resourceNotFoundException.getMessage(),
                resourceNotFoundException.getCause(),
                HttpStatus.NOT_FOUND

                );
        return new ResponseEntity<>(employeeExceptions, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DatabaseException.class})
    public ResponseEntity<Object> handleDatabaseException(DatabaseException databaseException){
        employeeExceptions employeeExceptions=new employeeExceptions(
                databaseException.getMessage(),
                databaseException.getCause(),
                HttpStatus.NOT_FOUND

        );
        return new ResponseEntity<>(employeeExceptions, HttpStatus.NOT_FOUND);
    }
}
