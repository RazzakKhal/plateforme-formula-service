package com.bookNDrive.formula_service.domain.exceptions;

public class FormulaNotFoundException extends RuntimeException {

    private static final String STATUS = "FORMULA.NOT.FOUND";
    private final Long formulaId;

    public FormulaNotFoundException(Long formulaId) {
        super("Formula not found for id: " + formulaId);
        this.formulaId = formulaId;
    }

    public Long getFormulaId() {
        return formulaId;
    }

    public String getStatus() {
        return STATUS;
    }
}
