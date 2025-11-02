package com.bookNDrive.formula_service.domain.models;

public record Formula(
        Long id,
        String title,
        String description,
        Double price,
        boolean code,
        Double promotionnalPrice
) {


    public Formula withId(Long newId) {
        return new Formula(newId, title, description, price, code, promotionnalPrice);
    }
}
