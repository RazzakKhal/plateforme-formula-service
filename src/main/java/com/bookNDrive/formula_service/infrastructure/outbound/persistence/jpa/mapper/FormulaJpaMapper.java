package com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa.mapper;

import com.bookNDrive.formula_service.domain.models.Formula;
import com.bookNDrive.formula_service.infrastructure.outbound.persistence.jpa.entity.FormulaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormulaJpaMapper {

    FormulaEntity toEntity(Formula formula);

    Formula toDomain(FormulaEntity entity);

    List<Formula> toDomainList(List<FormulaEntity> entities);
}
