package com.bookNDrive.formula_service.infrastructure.inbound.web.controller;

import com.bookNDrive.formula_service.application.port.FormulaCrudUseCase;
import com.bookNDrive.formula_service.infrastructure.inbound.web.dto.FormulaRequest;
import com.bookNDrive.formula_service.infrastructure.inbound.web.dto.FormulaResponse;
import com.bookNDrive.formula_service.infrastructure.inbound.web.mapper.FormulaWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/formulas")
public class CrudController {

    private final FormulaCrudUseCase formulaCrudUseCase;
    private final FormulaWebMapper formulaWebMapper;

    public CrudController(FormulaCrudUseCase formulaCrudUseCase, FormulaWebMapper formulaWebMapper) {
        this.formulaCrudUseCase = formulaCrudUseCase;
        this.formulaWebMapper = formulaWebMapper;
    }

    @PostMapping
    public ResponseEntity<FormulaResponse> createFormula(@Valid @RequestBody FormulaRequest request) {
        var created = formulaCrudUseCase.createFormula(formulaWebMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(formulaWebMapper.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormulaResponse> updateFormula(@PathVariable Long id,
                                                          @Valid @RequestBody FormulaRequest request) {
        var updated = formulaCrudUseCase.updateFormula(id, formulaWebMapper.toDomain(id, request));
        return ResponseEntity.ok(formulaWebMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFormula(@PathVariable Long id) {
        formulaCrudUseCase.deleteFormula(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormulaResponse> getFormula(@PathVariable Long id) {
        var formula = formulaCrudUseCase.getFormula(id);
        return ResponseEntity.ok(formulaWebMapper.toResponse(formula));
    }

    @GetMapping
    public ResponseEntity<List<FormulaResponse>> getAllFormulas() {
        var formulas = formulaCrudUseCase.getAllFormulas();
        return ResponseEntity.ok(formulaWebMapper.toResponseList(formulas));
    }

    @GetMapping("/authentication")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }
}
