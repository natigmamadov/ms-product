package com.example.ms.product.mapper;

import com.example.ms.product.dao.entity.ProductEntity;
import com.example.ms.product.model.enums.ProductStatus;
import com.example.ms.product.model.request.CreateProductRequest;
import com.example.ms.product.model.request.UpdateProductRequest;
import com.example.ms.product.model.response.ProductResponse;

import java.time.LocalDateTime;

import static com.example.ms.product.model.enums.ProductStatus.*;

public enum ProductMapper {
    PRODUCT_MAPPER;

    public ProductEntity buildProductEntity(CreateProductRequest createProductRequest) {
        return ProductEntity.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .categoryId(createProductRequest.getCategoryId())
                .productStatus(ACTIVE)
                .description(createProductRequest.getDescription())
                .quantity(createProductRequest.getQuantity())
                .build();
    }

    public ProductResponse buildProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .categoryId(productEntity.getCategoryId())
                .productStatus(productEntity.getProductStatus())
                .description(productEntity.getDescription())
                .quantity(productEntity.getQuantity())
                .build();
    }

//    public ProductEntity buildProductEntityFromUpdateProductRequest(Long id,UpdateProductRequest updateProductRequest) {
//        return ProductEntity.builder()
//                .id(id)
//                .name(updateProductRequest.getName())
//                .price(updateProductRequest.getPrice())
//                .productStatus(updateProductRequest.getProductStatus())
//                .categoryId(updateProductRequest.getCategoryId())
//                .updatedOn(LocalDateTime.now())
//                .build();
//    }

    public void buildProductEntityFromUpdateProductRequest(ProductEntity productEntity, UpdateProductRequest updateProductRequest) {
        productEntity.setName(updateProductRequest.getName());
        productEntity.setPrice(updateProductRequest.getPrice());
        productEntity.setProductStatus(updateProductRequest.getProductStatus());
        productEntity.setCategoryId(updateProductRequest.getCategoryId());
        productEntity.setDescription(updateProductRequest.getDescription());
        productEntity.setQuantity(updateProductRequest.getQuantity());
        productEntity.setUpdatedOn(LocalDateTime.now());
    }
}
