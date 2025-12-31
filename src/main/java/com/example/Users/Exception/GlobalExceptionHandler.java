package com.example.Users.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<String>handle(UserNotFoundException ex)
{
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}
}
