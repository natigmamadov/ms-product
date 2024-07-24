package com.example.ms.product.model.request;

import com.example.ms.product.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {


    private String name;

    private BigDecimal price;

    private Long categoryId;

    private ProductStatus productStatus;

    private String description;

    private Integer quantity;
}
