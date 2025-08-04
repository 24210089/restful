package com.example.demo.Service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IdinvalidException.class)
    public ResponseEntity<String> handleException(IdinvalidException idException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(idException.getMessage());
    }
}
