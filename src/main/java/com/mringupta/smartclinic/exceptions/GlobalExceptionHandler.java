package com.mringupta.smartclinic.exceptions;

import com.mringupta.smartclinic.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseObject<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()){

        }
    }
}
