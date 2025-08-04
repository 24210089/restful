package com.example.demo.Service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Domain.RestResponse;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IdinvalidException.class)
    public ResponseEntity<RestResponse<Object>> handleIdinvalidException(IdinvalidException idException) {

        // Tạo RestResponse cho error case
        RestResponse<Object> response = new RestResponse<>();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value()); // 400
        response.setError(idException.getMessage()); // Chi tiết lỗi
        response.setMessage("Validation Error");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
