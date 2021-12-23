package com.ibm.animalshelter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbrigoController {

    @GetMapping
    public String HelloWorld()
    {
        return "Hello World!";
    }
}
