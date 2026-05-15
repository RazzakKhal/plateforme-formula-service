package com.bookNDrive.formula_service.repositories;

import com.bookNDrive.formula_service.entities.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, UUID> {
}
