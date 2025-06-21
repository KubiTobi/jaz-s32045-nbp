package com.jazs32045nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.LimitExceededException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(LimitExceededException.class)
    public ResponseEntity<String> handleLimitExceededException(LimitExceededException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Błąd: " + ex.getMessage());
    }
}
