package com.example.ms.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InsufficientQuantityException extends RuntimeException {
    private String code;

    public InsufficientQuantityException(String code, String message) {
        super(message);
        this.code = code;
    }
}
