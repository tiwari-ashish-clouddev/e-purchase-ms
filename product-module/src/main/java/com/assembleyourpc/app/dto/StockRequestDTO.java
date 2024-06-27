package com.assembleyourpc.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StockRequestDTO(
        @NotBlank(message = "Product Cannot be Empty Or Null.")
        Long productId,
        @NotBlank(message = "Product Quantity Field Cannot be Empty Or Null.")
        @Min(value = 1, message = "Quantity Cannot be less than 1")
        Integer productQuantity
) {
}
