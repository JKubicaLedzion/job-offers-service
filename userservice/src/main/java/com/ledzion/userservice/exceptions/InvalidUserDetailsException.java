package com.ledzion.userservice.exceptions;

public class InvalidUserDetailsException extends RuntimeException {

    public InvalidUserDetailsException(String message) {
        super(message);
    }
}
