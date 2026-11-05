package com.satyam._5resttouristmanageapiglobalexcep.advice;

import com.satyam._5resttouristmanageapiglobalexcep.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristControllerAdvice {
    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerTouristException(TouristNotFoundException tnf) {
        ErrorDetails error = new ErrorDetails("404 Not FOund ", tnf.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handlerException(Exception tnf) {
        ErrorDetails error = new ErrorDetails("Intrnal Server Error ", tnf.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
