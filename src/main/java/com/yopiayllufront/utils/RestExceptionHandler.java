package com.yopiayllufront.utils;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.auth.login.LoginException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(LoginException exc) {
        return buildResponseEntity(HttpStatus.UNAUTHORIZED, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc){
        return buildResponseEntity(HttpStatus.BAD_REQUEST, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(DuplicateKeyException exc){
        return buildResponseEntity(HttpStatus.BAD_REQUEST, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exc){
        return buildResponseEntity(HttpStatus.BAD_REQUEST, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(InvalidDataExeption exc){
        List<String> errors = exc.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return buildResponseEntity(HttpStatus.BAD_REQUEST, new RuntimeException("Data enviada es invalida"), errors);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException exc){
        return buildResponseEntity(HttpStatus.BAD_REQUEST, new RuntimeException("Tipo de Argumento invalido"));
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(Exception exc){
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exc);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus status, Exception exc){
        return buildResponseEntity(status, exc, null);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus status, Exception exc, List<String> errors){
        ErrorResponse error = new ErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(status.value());
        error.setTimestamp(new Date());
        return new ResponseEntity<>(error, status);
    }
}
