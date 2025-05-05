package com.mringupta.smartclinic.exceptions;

import com.mringupta.smartclinic.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseObject<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseObject.error(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseObject<Void>> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseObject.error(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseObject<Void>> handleGeneralException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseObject.error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
