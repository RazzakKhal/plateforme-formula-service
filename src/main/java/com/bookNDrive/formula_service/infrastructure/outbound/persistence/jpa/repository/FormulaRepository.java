package com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa.repository;

import com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa.entity.FormulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<FormulaEntity, Long> {
}
