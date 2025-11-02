package com.bookNDrive.formula_service.infrastructure.inbound.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FormulaRequest(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull @Positive Double price,
        boolean code,
        Double promotionnalPrice
) {
}
