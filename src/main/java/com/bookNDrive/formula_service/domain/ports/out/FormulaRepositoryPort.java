package com.bookNDrive.formula_service.domain.ports.out;

import com.bookNDrive.formula_service.domain.models.Formula;

import java.util.List;
import java.util.Optional;

public interface FormulaRepositoryPort {

    List<Formula> findAll();
    Optional<Formula> findById(Long id);
    Formula save(Formula formula);
    void deleteById(Long formulaId);
}
