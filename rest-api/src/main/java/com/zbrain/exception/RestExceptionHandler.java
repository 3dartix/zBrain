package com.zbrain.exception;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@CommonsLog
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Object> notFoundExceptionHandler(DuplicateException exception, WebRequest request) {
        String errorDescription = exception.getLocalizedMessage();

        if(errorDescription == null) {
            errorDescription = exception.toString();
        }

        ErrorMessage error = new ErrorMessage(true);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
