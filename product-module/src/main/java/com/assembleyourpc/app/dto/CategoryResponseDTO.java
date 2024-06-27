package com.assembleyourpc.app.dto;

import java.time.LocalDateTime;

public record CategoryResponseDTO(
        Long categoryId,
        String categoryName,
        LocalDateTime categoryCreationDT
) {
}
