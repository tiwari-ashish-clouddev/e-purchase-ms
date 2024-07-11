package com.assembleyourpc.app.dto;

import jakarta.validation.constraints.NotBlank;

public record BrandRequestDTO(
        @NotBlank(message = "Brand Name Cannot be Empty Or Null.")
        String brandName,
        @NotBlank(message = "Brand Description field cannot be Empty or Null.")
        String brandDesc
) {
}
