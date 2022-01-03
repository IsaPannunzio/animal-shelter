package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/abrigo")
public class AbrigoController {

@Autowired
AbrigoService abrigoService;

@PostMapping("/create")
public Abrigo createAbrigo(@RequestBody Abrigo abrigo){
    return abrigoService.createAbrigo(abrigo);
}

}
