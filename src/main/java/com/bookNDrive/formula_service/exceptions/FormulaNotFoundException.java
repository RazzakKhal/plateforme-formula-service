package com.bookNDrive.formula_service.exceptions;

import com.bookndrive.common.error.ApiException;
import org.springframework.http.HttpStatus;

public class FormulaNotFoundException extends ApiException {

    public FormulaNotFoundException(Long formulaId) {
        super(
                "Aucune formule ne correspond à l'identifiant " + formulaId,
                FormulaErrorCodes.FORMULA_NOT_FOUND,
                HttpStatus.NOT_FOUND.value()
        );
    }
}
