package com.bookNDrive.formula_service.dtos.sended;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public record FormulaDto(
        UUID id,
        @NotBlank(message = "must not be blank")
        String title,
        @NotBlank(message = "must not be blank")
        String description,
        @NotNull(message = "must not be null")
        @PositiveOrZero(message = "must be greater than or equal to 0")
        Double price,
        boolean code,
        @PositiveOrZero(message = "must be greater than or equal to 0")
        Double promotionnalPrice
) {
}
