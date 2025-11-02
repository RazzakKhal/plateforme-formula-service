package com.bookNDrive.formula_service.configuration;

import com.bookNDrive.formula_service.application.service.ManageFormulaService;
import com.bookNDrive.formula_service.application.service.port.FormulaCrudUseCase;
import com.bookNDrive.formula_service.domain.ports.out.FormulaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormulaApplicationConfig {

    @Bean
    FormulaCrudUseCase formulaCrudUseCase(FormulaRepositoryPort formulaRepositoryPort){
        return new ManageFormulaService(formulaRepositoryPort);
    }
}
