package com.example.ms.product.dao.repository;

import com.example.ms.product.dao.entity.ProductEntity;
import com.example.ms.product.model.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    Optional<ProductEntity> findByIdAndProductStatusNot(Long id, ProductStatus productStatus);
}
