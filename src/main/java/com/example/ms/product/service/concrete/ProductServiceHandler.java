package com.example.ms.product.service.concrete;

import com.example.ms.product.dao.entity.ProductEntity;
import com.example.ms.product.dao.repository.ProductRepository;
import com.example.ms.product.exception.InsufficientQuantityException;
import com.example.ms.product.exception.NotFoundException;
import com.example.ms.product.model.request.CreateProductRequest;
import com.example.ms.product.model.request.ReduceQuantityRequest;
import com.example.ms.product.model.request.UpdateProductRequest;
import com.example.ms.product.model.response.ProductResponse;
import com.example.ms.product.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.product.exception.ExceptionConstants.*;
import static com.example.ms.product.mapper.ProductMapper.PRODUCT_MAPPER;
import static com.example.ms.product.model.enums.ProductStatus.DELETED;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceHandler implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(CreateProductRequest createProductRequest) {
        productRepository.save(PRODUCT_MAPPER.buildProductEntity(createProductRequest));
    }

    @Override
    public ProductResponse getProductById(Long id) {
        var productEntity = fetchIfExists(id);
        return PRODUCT_MAPPER.buildProductResponse(productEntity);
    }

    @Override
    public void updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        var productEntity = fetchIfExists(id);
        PRODUCT_MAPPER.buildProductEntityFromUpdateProductRequest(productEntity, updateProductRequest);
        productRepository.save(productEntity);
    }

    @Override
    public void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest) {
        Long productId = reduceQuantityRequest.getProductId();
        var productEntity = fetchIfExists(productId);

        if (productEntity.getQuantity() < reduceQuantityRequest.getQuantity()) {
            throw new InsufficientQuantityException(INSUFFICIENT_QUANTITY_CODE,
                    String.format(INSUFFICIENT_QUANTITY_MESSAGE, productId));
        }

        productEntity.setQuantity(
                productEntity.getQuantity() - reduceQuantityRequest.getQuantity()
        );

        productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        var productEntity = fetchIfExists(id);
        productEntity.setProductStatus(DELETED);
        productRepository.save(productEntity);
    }

    public ProductEntity fetchIfExists(Long id) {
        return productRepository.findByIdAndProductStatusNot(id, DELETED).
                orElseThrow(() ->
                        new NotFoundException(PRODUCT_NOT_FOUND_CODE,
                                String.format(PRODUCT_NOT_FOUND_MESSAGE, id)));
    }
}
