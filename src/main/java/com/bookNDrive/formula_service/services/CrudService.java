package com.bookNDrive.formula_service.services;

import com.bookNDrive.formula_service.dtos.sended.FormulaDto;
import com.bookNDrive.formula_service.exceptions.FormulaNotFoundException;
import com.bookNDrive.formula_service.mappers.FormulaMapper;
import com.bookNDrive.formula_service.repositories.FormulaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrudService {

    private final FormulaRepository formulaRepository;
    private final FormulaMapper formulaMapper;

    @Autowired
    public CrudService(FormulaRepository formulaRepository, FormulaMapper formulaMapper) {
        this.formulaRepository = formulaRepository;
        this.formulaMapper = formulaMapper;
    }

    public FormulaDto getFormula(Long id) {
        log.info("Recuperation d'une formule demandee formulaId={}", id);
        var formula = formulaRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Formule introuvable formulaId={}", id);
                    return new FormulaNotFoundException(id);
                });
        log.info("Formule recuperee formulaId={}", id);
        return formulaMapper.formulaToFormulaDto(formula);
    }

    public Page<FormulaDto> getAllFormulas(Pageable pageable) {
        var formulas = formulaRepository.findAll(pageable)
                .map(formulaMapper::formulaToFormulaDto);
        log.info(
                "Liste de formules recuperee page={} size={} sort={} returnedElements={}",
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort(),
                formulas.getNumberOfElements()
        );
        return formulas;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public FormulaDto createFormula(FormulaDto formula) {
        log.info(
                "Creation d'une formule demandee title={} price={} promotionnalPrice={}",
                formula.title(),
                formula.price(),
                formula.promotionnalPrice()
        );
        var formulaEntity = formulaRepository.save(formulaMapper.formulaDtoToFormula(formula));
        log.info("Formule creee formulaId={}", formulaEntity.getId());
        return formulaMapper.formulaToFormulaDto(formulaEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFormula(Long formulaId) {
        log.info("Suppression d'une formule demandee formulaId={}", formulaId);
        if (!formulaRepository.existsById(formulaId)) {
            log.warn("Suppression impossible, formule introuvable formulaId={}", formulaId);
            throw new FormulaNotFoundException(formulaId);
        }
        formulaRepository.deleteById(formulaId);
        log.info("Formule supprimee formulaId={}", formulaId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public FormulaDto updateFormula(Long formulaId, FormulaDto formulaDto) {
        log.info(
                "Mise a jour d'une formule demandee formulaId={} title={} price={} promotionnalPrice={}",
                formulaId,
                formulaDto.title(),
                formulaDto.price(),
                formulaDto.promotionnalPrice()
        );
        formulaRepository.findById(formulaId)
                .orElseThrow(() -> {
                    log.warn("Mise a jour impossible, formule introuvable formulaId={}", formulaId);
                    return new FormulaNotFoundException(formulaId);
                });

        var formulaEntity = formulaRepository.save(formulaMapper.formulaDtoToExistingFormula(formulaDto));
        log.info("Formule mise a jour formulaId={}", formulaId);
        return formulaMapper.formulaToFormulaDto(formulaEntity);
    }
}
