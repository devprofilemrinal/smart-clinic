package com.mringupta.smartclinic.response;

import java.time.LocalDateTime;

public record ResponseObject<T>(
        LocalDateTime timestamp,
        int statusCode,
        String message,
        T data

) {
    public static <T> ResponseObject<T> success(String message, int statusCode, T data){
        return new ResponseObject<>(LocalDateTime.now(), statusCode, message, data);
    }

    public static <T> ResponseObject<T> error(String message, int statusCode){
        return new ResponseObject<>(LocalDateTime.now(), statusCode, message, null);
    }
}
