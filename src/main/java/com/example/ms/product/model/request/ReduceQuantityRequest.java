package com.example.ms.product.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.example.ms.product.model.constants.ApplicationConstants.PRODUCT_ID_IS_REQUIRED;
import static com.example.ms.product.model.constants.ApplicationConstants.QUANTITY_IS_REQUIRED;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReduceQuantityRequest {
    @NotNull(message = PRODUCT_ID_IS_REQUIRED)
    private Long productId;

    @NotNull(message = QUANTITY_IS_REQUIRED)
    private Integer quantity;
}
