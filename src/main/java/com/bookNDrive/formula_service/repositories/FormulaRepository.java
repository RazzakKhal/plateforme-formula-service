package com.bookNDrive.formula_service.repositories;

import com.bookNDrive.formula_service.models.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
}
