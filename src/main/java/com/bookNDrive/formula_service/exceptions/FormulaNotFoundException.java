package com.bookNDrive.formula_service.exceptions;

import com.bookndrive.common.error.ApiException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class FormulaNotFoundException extends ApiException {

    public FormulaNotFoundException(UUID formulaId) {
        super(
                "Aucune formule ne correspond a l'identifiant " + formulaId,
                FormulaErrorCodes.FORMULA_NOT_FOUND,
                HttpStatus.NOT_FOUND.value()
        );
    }
}
