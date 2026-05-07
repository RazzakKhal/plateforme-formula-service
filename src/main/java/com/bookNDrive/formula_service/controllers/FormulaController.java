package com.bookNDrive.formula_service.controllers;

import com.bookNDrive.formula_service.dtos.sended.FormulaDto;
import com.bookNDrive.formula_service.services.CrudService;
import com.bookndrive.common.error.ErrorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formulas")
@Tag(name = "Formula Controller", description = "Expose les operations CRUD sur les formules.")
public class FormulaController {

    private CrudService crudService;

    @Autowired
    public FormulaController(CrudService crudService) {
        this.crudService = crudService;
    }


    @Operation(
            summary = "Creer une formule",
            description = "Cree une nouvelle formule et retourne la formule enregistree."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Formule creee avec succes",
                    content = @Content(schema = @Schema(implementation = FormulaDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requete invalide ou erreur remontee par le service",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentification requise",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acces refuse, le role ADMIN est requis",
                    content = @Content
            )
    })
    @PostMapping("")
    public ResponseEntity<FormulaDto> createFormula(@RequestBody FormulaDto formula) {

        return ResponseEntity.status(201).body(crudService.createFormula(formula));
    }

    @Operation(
            summary = "Mettre a jour une formule",
            description = "Met a jour une formule existante a partir de son identifiant."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Formule mise a jour avec succes",
                    content = @Content(schema = @Schema(implementation = FormulaDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requete invalide ou formule introuvable",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentification requise",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acces refuse, le role ADMIN est requis",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<FormulaDto> updateFormula(@PathVariable Long id, @RequestBody FormulaDto formulaDto) {

        return ResponseEntity.ok(crudService.updateFormula(id, formulaDto));
    }

    @Operation(
            summary = "Supprimer une formule",
            description = "Supprime une formule a partir de son identifiant."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Formule supprimee avec succes",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Identifiant invalide ou formule introuvable",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentification requise",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acces refuse, le role ADMIN est requis",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFormula(@PathVariable Long id) {
        crudService.deleteFormula(id);
    }

    @Operation(
            summary = "Recuperer une formule",
            description = "Retourne une formule a partir de son identifiant."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Formule retournee avec succes",
                    content = @Content(schema = @Schema(implementation = FormulaDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Identifiant invalide ou formule introuvable",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentification requise",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<FormulaDto> getFormula(@PathVariable Long id) {

        return ResponseEntity.ok(crudService.getFormula(id));
    }

    @Operation(
            summary = "Lister les formules",
            description = "Retourne la liste paginee des formules."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Liste des formules retournee avec succes"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parametres de pagination invalides",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @GetMapping("")
    public ResponseEntity<Page<FormulaDto>> getAllFormulas(
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        return ResponseEntity.ok(crudService.getAllFormulas(pageable));
    }

}
