package com.bookNDrive.formula_service.application.service;

import com.bookNDrive.formula_service.application.port.FormulaCrudUseCase;
import com.bookNDrive.formula_service.domain.exceptions.FormulaNotFoundException;
import com.bookNDrive.formula_service.domain.models.Formula;
import com.bookNDrive.formula_service.domain.ports.out.FormulaRepositoryPort;

import java.util.List;

public class ManageFormulaService implements FormulaCrudUseCase {

    private final FormulaRepositoryPort formulaRepositoryPort;

    public ManageFormulaService(FormulaRepositoryPort formulaRepositoryPort) {
        this.formulaRepositoryPort = formulaRepositoryPort;
    }

    @Override
    public Formula getFormula(Long id) {
        return formulaRepositoryPort.findById(id)
                .orElseThrow(() -> new FormulaNotFoundException(id));
    }

    @Override
    public List<Formula> getAllFormulas() {
        return formulaRepositoryPort.findAll();
    }

    @Override
    public Formula createFormula(Formula formula) {
        return formulaRepositoryPort.save(formula);
    }

    @Override
    public void deleteFormula(Long formulaId) {
        if (formulaRepositoryPort.findById(formulaId).isEmpty()) {
            throw new FormulaNotFoundException(formulaId);
        }
        formulaRepositoryPort.deleteById(formulaId);
    }

    @Override
    public Formula updateFormula(Long formulaId, Formula formula) {
        formulaRepositoryPort.findById(formulaId)
                .orElseThrow(() -> new FormulaNotFoundException(formulaId));

        return formulaRepositoryPort.save(formula.withId(formulaId));
    }
}
