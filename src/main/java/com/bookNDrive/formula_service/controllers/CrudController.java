package com.bookNDrive.formula_service.controllers;

import com.bookNDrive.formula_service.dtos.sended.FormulaDto;
import com.bookNDrive.formula_service.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulas")
public class CrudController {

    private CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }


    @PostMapping("")
    public ResponseEntity<FormulaDto> createFormula(@RequestBody FormulaDto formula) {

        return ResponseEntity.status(201).body(crudService.createFormula(formula));
    }

    public String updateFormula() {

        return "";
    }

    public String deleteFormula() {

        return "";
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormulaDto> getFormula(@PathVariable Long id) {

        return ResponseEntity.ok(crudService.getFormula(id));
    }

    @GetMapping("")
    public ResponseEntity<List<FormulaDto>> getAllFormulas() {
        return ResponseEntity.ok(crudService.getAllFormulas());
    }

    @GetMapping("authentication")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }
}
