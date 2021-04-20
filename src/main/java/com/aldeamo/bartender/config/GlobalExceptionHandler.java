package com.aldeamo.bartender.config;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;


/**
 * The global exception handler class. All exceptions will be redirected here to be formatted
 * and be send to the client.
 * */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * The common exception for the system.
     *
     * @param illegalStateException The exception object with all information of the exception thrown.
     * @return The formatted response to the client.
     * */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map> illegalStateException(IllegalStateException illegalStateException) {
        return new ResponseEntity<>(new HashMap(){{
            put("messages", Arrays.asList(illegalStateException.getMessage()));
        }}, HttpStatus.BAD_REQUEST);
    }

    /**
     * If incoming fields are not set correctly or invalid values, this handler will be executed.
     *
     * @param methodArgumentNotValidException The exception object with all information of the exception thrown.
     * @return The formatted response to the client.
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> errors = new ArrayList<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.add(fieldError.getDefaultMessage());
        });

        return new ResponseEntity<>(new HashMap(){{
            put("messages", errors);
        }}, HttpStatus.BAD_REQUEST);
    }

}
