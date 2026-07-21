package com.ecommerce.Ecom_Exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class My_Global_Exception_Handler {

    @ExceptionHandler(MethodArgumentNotValidException.class)

    // This method handles MethodArgumentNotValidException and returns a map of
    // field errors and their corresponding error messages.
    // It is annotated with @ExceptionHandler to specify that it handles this
    // specific
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        // Iterate through the field errors and populate the errorResponse map with
        // field names and error messages.
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorResponse.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
