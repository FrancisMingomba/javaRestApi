package com.example.java.rest.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends  ResponseEntityExceptionHandler {
    
     @ExceptionHandler(DuplicateUserException.class)
     public ResponseEntity<String> authenticationException(DuplicateUserException exception,
            WebRequest request) {
        return badRequest(exception.getMessage());
    }

      private ResponseEntity<String> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(message);
    }

    
}
