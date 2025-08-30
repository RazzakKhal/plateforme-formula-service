package com.bookNDrive.formula_service.services;

import com.bookNDrive.formula_service.dtos.sended.FormulaDto;
import com.bookNDrive.formula_service.mappers.FormulaMapper;
import com.bookNDrive.formula_service.repositories.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

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
        var formula = formulaRepository.findById(id).orElseThrow(() -> new RuntimeException("formula doesn't find in bdd"));
        return formulaMapper.formulaToFormulaDto(formula);
    }

    public List<FormulaDto> getAllFormulas() {
        return formulaMapper.formulasToFormulaDtos(formulaRepository.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    public FormulaDto createFormula(FormulaDto formula) {

        var formulaEntity = formulaRepository.save(formulaMapper.formulaDtoToFormula(formula));
        return formulaMapper.formulaToFormulaDto(formulaEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFormula(Long formulaId) {
        formulaRepository.deleteById(formulaId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public FormulaDto updateFormula(Long formulaId, FormulaDto formulaDto) {
        formulaRepository.findById(formulaId).orElseThrow(() -> {
            throw new RuntimeException("Formule non trouvée en bdd");
        });

        var formulaEntity = formulaRepository.save(formulaMapper.formulaDtoToFormula(formulaDto));
        return formulaMapper.formulaToFormulaDto(formulaEntity);

    }

}
