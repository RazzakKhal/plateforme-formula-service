package com.bookNDrive.formula_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
@OpenAPIDefinition(
        info = @Info(
                title = "Formula Service",
                description = "Microservice responsable des formules (forfaits)"
        )
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class FormulaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormulaServiceApplication.class, args);
    }

}
