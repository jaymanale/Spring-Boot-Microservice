package com.spring.microservice.springbootmicroservicerestapi.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){

    ErrorDetails errorDetails  = new ErrorDetails(
        LocalDateTime.now(),
        resourceNotFoundException.getMessage(),
        webRequest.getDescription(false),
        "USER_NOT_FOUND"
    );

    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EmailAlreadyExistException.class)
  public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException emailAlreadyExistException, WebRequest webRequest){

    ErrorDetails errorDetails  = new ErrorDetails(
        LocalDateTime.now(),
        emailAlreadyExistException.getMessage(),
        webRequest.getDescription(false),
        "USER_EMAIL_ALREADY_EXIST"
    );

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }
}
