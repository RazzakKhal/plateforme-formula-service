package com.bookNDrive.formula_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class FormulaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormulaServiceApplication.class, args);
    }

}
