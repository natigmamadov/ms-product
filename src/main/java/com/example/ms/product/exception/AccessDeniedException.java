package com.example.ms.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessDeniedException extends RuntimeException {
    private String code;

    public AccessDeniedException(String code, String message) {
        super(message);
        this.code = code;
    }
}
