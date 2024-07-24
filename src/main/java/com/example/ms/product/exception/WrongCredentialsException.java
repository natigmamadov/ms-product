package com.example.ms.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WrongCredentialsException extends RuntimeException {
    private String code;

    public WrongCredentialsException(String code, String message) {
        super(message);
        this.code = code;
    }
}
