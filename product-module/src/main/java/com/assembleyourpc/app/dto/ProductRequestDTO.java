package com.assembleyourpc.app.dto;

public record ProductRequestDTO(
        String productTitle,
        String productName,
        String productDesc,
        Double productPricePerUnit,
        Long brandId,
        Long categoryId,
        Integer productQuantity
) {
}
