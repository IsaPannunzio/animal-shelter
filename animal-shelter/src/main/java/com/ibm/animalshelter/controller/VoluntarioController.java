package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Voluntario;
import com.ibm.animalshelter.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {

    @Autowired
    VoluntarioService voluntarioService;

    @PostMapping("/create")
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioService.createVoluntario(voluntario);
    }

}
