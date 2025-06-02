package com.rental.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<?> handleNotFound(PaymentNotFoundException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "Not Found");
        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());
        map.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "Internal Server Error");
        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}