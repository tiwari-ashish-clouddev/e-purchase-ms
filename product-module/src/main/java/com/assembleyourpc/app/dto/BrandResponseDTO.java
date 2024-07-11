package com.assembleyourpc.app.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record BrandResponseDTO(
        Long brandId,
        @NotBlank(message = "Brand Name Cannot be Empty Or Null.")
        String brandName,
        @NotBlank(message = "Brand Description field cannot be Empty or Null.")
        String brandDesc,
        LocalDateTime brandCreationDT
) {
}
