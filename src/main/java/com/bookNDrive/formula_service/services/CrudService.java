package com.bookNDrive.formula_service.services;

import com.bookNDrive.formula_service.dtos.sended.FormulaDto;
import com.bookNDrive.formula_service.exceptions.FormulaNotFoundException;
import com.bookNDrive.formula_service.mappers.FormulaMapper;
import com.bookNDrive.formula_service.repositories.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    private final FormulaRepository formulaRepository;
    private final FormulaMapper formulaMapper;

    @Autowired
    public CrudService(FormulaRepository formulaRepository, FormulaMapper formulaMapper) {
        this.formulaRepository = formulaRepository;
        this.formulaMapper = formulaMapper;
    }

    public FormulaDto getFormula(Long id) {
        var formula = formulaRepository.findById(id)
                .orElseThrow(() -> new FormulaNotFoundException(id));
        return formulaMapper.formulaToFormulaDto(formula);
    }

    public Page<FormulaDto> getAllFormulas(Pageable pageable) {
        return formulaRepository.findAll(pageable)
                .map(formulaMapper::formulaToFormulaDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public FormulaDto createFormula(FormulaDto formula) {
        var formulaEntity = formulaRepository.save(formulaMapper.formulaDtoToFormula(formula));
        return formulaMapper.formulaToFormulaDto(formulaEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFormula(Long formulaId) {
        if (!formulaRepository.existsById(formulaId)) {
            throw new FormulaNotFoundException(formulaId);
        }
        formulaRepository.deleteById(formulaId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public FormulaDto updateFormula(Long formulaId, FormulaDto formulaDto) {
        formulaRepository.findById(formulaId)
                .orElseThrow(() -> new FormulaNotFoundException(formulaId));

        var formulaEntity = formulaRepository.save(formulaMapper.formulaDtoToExistingFormula(formulaDto));
        return formulaMapper.formulaToFormulaDto(formulaEntity);
    }
}
