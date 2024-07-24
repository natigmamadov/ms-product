package com.example.ms.product.exception;

public interface ExceptionConstants {
    String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION";
    String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected exception occurred";

    String PRODUCT_NOT_FOUND_CODE = "PRODUCT_NOT_FOUND";
    String PRODUCT_NOT_FOUND_MESSAGE = "PRODUCT with id: %s not found";

    String  ACCESS_DENIED_CODE = "ACCESS_DENIED";
    String  ACCESS_DENIED_MESSAGE = "User doesn't have access for this operation!";


    String  INSUFFICIENT_QUANTITY_CODE = "INSUFFICIENT_QUANTITY";
    String  INSUFFICIENT_QUANTITY_MESSAGE = "Insufficient quantity for product id :%s";
}
