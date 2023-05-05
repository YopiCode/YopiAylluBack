package com.yopiayllufront.utils;

import org.springframework.validation.BindingResult;

import java.io.Serial;

public class InvalidDataExeption extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient BindingResult result;

    public InvalidDataExeption(BindingResult result) {
        super();
        this.result = result;
    }

    public InvalidDataExeption(BindingResult result, String message) {
        super(message);
        this.result = result;
    }

    public BindingResult getResult() {
        return result;
    }
}
