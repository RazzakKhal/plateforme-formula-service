package com.bookNDrive.formula_service.infrastructure.inbound.web.exception;

import com.bookNDrive.formula_service.domain.exceptions.FormulaNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerController {

    @ExceptionHandler(FormulaNotFoundException.class)
    public ResponseEntity<ApiError> handleFormulaNotFound(FormulaNotFoundException ex, HttpServletRequest request) {
        var body = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                ex.getStatus(),
                "formula.notFound",
                Map.of("formulaId", ex.getFormulaId()),
                ex.getMessage(),
                OffsetDateTime.now(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex, HttpServletRequest request) {
        var body = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "GLOBAL.ERROR",
                "global.error",
                Map.of(),
                ex.getMessage(),
                OffsetDateTime.now(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
