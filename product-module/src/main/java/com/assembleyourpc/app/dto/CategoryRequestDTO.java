package com.assembleyourpc.app.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank(message = "Category field cannot be Empty or Null.")
        String categoryName
) {
}
