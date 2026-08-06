package com.example.SpringDataJpaDemo.exception;

import com.example.SpringDataJpaDemo.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
            "USER_NOT_FOUND",
            ex.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleNotValidException(MethodArgumentNotValidException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
            "INVALID_INPUT",
            ex.getBindingResult().getFieldError().toString()
        ));
    }
}
