package com.bookNDrive.formula_service.infrastructure.inbound.web.mapper;

import com.bookNDrive.formula_service.domain.models.Formula;
import com.bookNDrive.formula_service.infrastructure.inbound.web.dto.FormulaRequest;
import com.bookNDrive.formula_service.infrastructure.inbound.web.dto.FormulaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormulaWebMapper {

    @Mapping(target = "id", ignore = true)
    Formula toDomain(FormulaRequest request);

    @Mapping(target = "id", source = "formulaId")
    Formula toDomain(Long formulaId, FormulaRequest request);

    FormulaResponse toResponse(Formula formula);

    List<FormulaResponse> toResponseList(List<Formula> formulas);
}
