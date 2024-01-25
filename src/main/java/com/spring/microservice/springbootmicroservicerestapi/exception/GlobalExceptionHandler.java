package com.spring.microservice.springbootmicroservicerestapi.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  // Handle Global Exception
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){

    ErrorDetails errorDetails  = new ErrorDetails(
        LocalDateTime.now(),
        exception.getMessage(),
        webRequest.getDescription(false),
        "INTERNAL_SERVER_ERROR"
    );

    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // Handle Custom Exception
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

  // To Handle field validation used by Hibernate validator @valid
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

    allErrors.forEach(error -> {
      String field = ((FieldError) error).getField();
      String message =  error.getDefaultMessage();
      errors.put(field, message);
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
