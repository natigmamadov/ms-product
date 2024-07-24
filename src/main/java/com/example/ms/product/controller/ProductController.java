package com.example.ms.product.controller;

import com.example.ms.product.model.request.CreateProductRequest;
import com.example.ms.product.model.request.UpdateProductRequest;
import com.example.ms.product.model.response.ProductResponse;
import com.example.ms.product.service.abstraction.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(CREATED)
    public void createProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        productService.createProduct(createProductRequest);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateProduct(@PathVariable Long id,@RequestBody UpdateProductRequest updateProductRequest) {
        productService.updateProduct(id,updateProductRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
