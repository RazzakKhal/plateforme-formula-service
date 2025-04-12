package com.bookNDrive.formula_service.services;

import com.bookNDrive.formula_service.models.Formula;
import com.bookNDrive.formula_service.repositories.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    private FormulaRepository formulaRepository;

    @Autowired
    public CrudService(FormulaRepository formulaRepository){
        this.formulaRepository = formulaRepository;
    }

    public Formula getFormula(Long id){
        return formulaRepository.findById(id).orElseThrow(() -> new RuntimeException("formula doesn't find in bdd"));
    }

    public List<Formula> getAllFormulas(){
        return formulaRepository.findAll();
    }

    public Formula createFormula(Formula formula){

        return formulaRepository.save(formula);
    }

}
