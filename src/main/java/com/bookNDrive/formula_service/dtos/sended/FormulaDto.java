package com.bookNDrive.formula_service.dtos.sended;

public record FormulaDto(Long id, String title, String description, Double price, boolean code,
                         Double promotionnalPrice) {

}