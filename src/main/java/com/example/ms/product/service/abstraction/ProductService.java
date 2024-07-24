package com.example.ms.product.service.abstraction;

import com.example.ms.product.model.request.CreateProductRequest;
import com.example.ms.product.model.request.ReduceQuantityRequest;
import com.example.ms.product.model.request.UpdateProductRequest;
import com.example.ms.product.model.response.ProductResponse;

public interface ProductService {
    void createProduct(CreateProductRequest createProductRequest);

    ProductResponse getProductById(Long id);

    void updateProduct(Long id,UpdateProductRequest updateProductRequest);

    void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest);

    void deleteProduct(Long id);
}
