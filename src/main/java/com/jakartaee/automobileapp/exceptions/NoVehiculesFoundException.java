package com.jakartaee.automobileapp.exceptions;

public class NoVehiculesFoundException extends RuntimeException {
    public NoVehiculesFoundException(String message) {
        super(message);
    }
}
