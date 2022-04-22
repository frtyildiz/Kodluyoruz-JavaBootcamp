package com.firat.flightReservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FlightExceptionHandling {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> methodNullPointerExceptionHandler (NullPointerException e)
    {
        String message = "Can not be gap: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> methodExceptionHandler (Exception e)
    {
        String message = "Ups! You've an Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }

}
