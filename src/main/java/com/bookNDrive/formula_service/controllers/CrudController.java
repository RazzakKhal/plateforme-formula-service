package com.bookNDrive.formula_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CrudController {

    @GetMapping("test")
    public String getEnv(){

        return "test ok";
    }
}
