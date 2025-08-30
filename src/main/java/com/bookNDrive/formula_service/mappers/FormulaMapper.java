package com.bookNDrive.formula_service.mappers;

import com.bookNDrive.formula_service.dtos.sended.FormulaDto;
import com.bookNDrive.formula_service.models.Formula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormulaMapper {

    FormulaMapper INSTANCE = Mappers.getMapper(FormulaMapper.class);

    @Mapping(target = "id", ignore = true)
    Formula formulaDtoToFormula(FormulaDto formulaDto);

    @Mapping(target = "id", ignore = false)
    FormulaDto formulaToFormulaDto(Formula formula);

    List<FormulaDto> formulasToFormulaDtos(List<Formula> formulas);


}
