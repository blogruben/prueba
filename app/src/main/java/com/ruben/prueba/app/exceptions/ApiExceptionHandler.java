package com.ruben.prueba.app.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

    
    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNoHandlerFoundException(
            NoResourceFoundException ex, HttpServletRequest httpServletRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(404, "Sorry!! The resource is not found. Try again.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(apiErrorResponse);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(404, "Sorry!! The resource is not found. Try again.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(apiErrorResponse);
    }


    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex, HttpServletRequest httpServletRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(400, "Sorry!! Bad request. Try with other param.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(apiErrorResponse);
    }


}