package com.example.taskmanager.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)

    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex, HttpServletRequest request) {
        ErrorResponse errorREsponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Account Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorREsponse, HttpStatus.NOT_FOUND);
    }
}
