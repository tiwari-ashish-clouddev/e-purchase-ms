package com.assembleyourpc.app.dto;

import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long productId,
        String productTitle,
        String productName,
        String productDesc,
        Double productPricePerUnit,
        LocalDateTime productCreationDT,
        LocalDateTime productLastUpdateDT,
        BrandResponseDTO brand,
        CategoryResponseDTO category,
        StockResponseDTO stock
) {
}
