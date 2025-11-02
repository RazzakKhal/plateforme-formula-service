package com.bookNDrive.formula_service.infrastructure.inbound.web.dto;

public record FormulaResponse(
        Long id,
        String title,
        String description,
        Double price,
        boolean code,
        Double promotionnalPrice
) {
}
