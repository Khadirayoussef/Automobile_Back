package com.jakartaee.automobileapp.handler;

import com.jakartaee.automobileapp.exceptions.NoVehiculesFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoVehiculesFoundException.class)
    public ResponseEntity<String> handleNoVehiculesFoundException(NoVehiculesFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
