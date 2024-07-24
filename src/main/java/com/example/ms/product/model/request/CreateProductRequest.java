package com.example.ms.product.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.example.ms.product.model.constants.ApplicationConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @NotBlank(message = NAME_IS_REQUIRED)
    private String name;
    @NotNull(message = PRICE_IS_REQUIRED)
    private BigDecimal price;
    @NotNull(message = CATEGORY_ID_IS_REQUIRED)
    private Long categoryId;
    @NotBlank(message = DESCRIPTION_IS_REQUIRED)
    private String description;
    @NotNull(message = QUANTITY_IS_REQUIRED)
    private Integer quantity;


}
