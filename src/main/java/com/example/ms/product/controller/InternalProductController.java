package com.example.ms.product.controller;

import com.example.ms.product.model.request.ReduceQuantityRequest;
import com.example.ms.product.model.response.ProductResponse;
import com.example.ms.product.service.abstraction.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("internal/v1/products")
@RequiredArgsConstructor
public class InternalProductController {
    private final ProductService productService;

    @PostMapping("/reduce-quantity")
    @ResponseStatus(NO_CONTENT)
    public void reduceQuantity(@RequestBody @Valid ReduceQuantityRequest reduceQuantityRequest) {
        productService.reduceQuantity(reduceQuantityRequest);
    }
}
