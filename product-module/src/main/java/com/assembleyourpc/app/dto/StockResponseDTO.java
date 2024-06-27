package com.assembleyourpc.app.dto;

import java.time.LocalDateTime;

public record StockResponseDTO(
        Long stockId,
        String productName,
        Integer productQuantity,
        LocalDateTime stockCreationDT
) {
}
