package com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa;

import com.bookNDrive.formula_service.domain.models.Formula;
import com.bookNDrive.formula_service.domain.ports.out.FormulaRepositoryPort;
import com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa.mapper.FormulaJpaMapper;
import com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa.repository.FormulaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FormulaRepositoryAdapter implements FormulaRepositoryPort {

    private final FormulaRepository formulaRepository;
    private final FormulaJpaMapper formulaJpaMapper;

    public FormulaRepositoryAdapter(FormulaRepository formulaRepository, FormulaJpaMapper formulaJpaMapper) {
        this.formulaRepository = formulaRepository;
        this.formulaJpaMapper = formulaJpaMapper;
    }

    @Override
    public List<Formula> findAll() {
        return formulaJpaMapper.toDomainList(formulaRepository.findAll());
    }

    @Override
    public Optional<Formula> findById(Long id) {
        return formulaRepository.findById(id).map(formulaJpaMapper::toDomain);
    }

    @Override
    public Formula save(Formula formula) {
        var savedEntity = formulaRepository.save(formulaJpaMapper.toEntity(formula));
        return formulaJpaMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long formulaId) {
        formulaRepository.deleteById(formulaId);
    }
}
