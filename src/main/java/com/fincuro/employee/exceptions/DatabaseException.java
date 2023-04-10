package com.fincuro.employee.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message) {
        super(message);
    }

}
