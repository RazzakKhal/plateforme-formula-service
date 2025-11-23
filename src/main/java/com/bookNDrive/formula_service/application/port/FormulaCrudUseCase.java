package com.bookNDrive.formula_service.application.port;

import com.bookNDrive.formula_service.domain.models.Formula;

import java.util.List;

public interface FormulaCrudUseCase {

    Formula getFormula(Long id);

    List<Formula> getAllFormulas();

    Formula createFormula(Formula formula);

    void deleteFormula(Long formulaId);

    Formula updateFormula(Long formulaId, Formula formula);
}
