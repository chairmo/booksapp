package com.chairmo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        String err = exception.getLocalizedMessage();
        if (err == null) err = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(err, LocalDateTime.now());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, ObjectNotFoundException.class})
    public ResponseEntity<Object> handleSpecificExceptions(Exception exception, WebRequest request) {
        String err = exception.getLocalizedMessage();
        if (err == null) err = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(err, LocalDateTime.now());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
