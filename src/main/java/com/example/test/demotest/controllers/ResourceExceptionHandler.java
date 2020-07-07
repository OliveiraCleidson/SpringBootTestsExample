package com.example.test.demotest.controllers;

import com.example.test.demotest.resources.exceptions.StandardError;
import com.example.test.demotest.services.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Resource not found";
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
