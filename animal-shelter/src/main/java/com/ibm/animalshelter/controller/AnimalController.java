package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping("/create")
    public Animal createAnimal(@RequestBody Animal animal){
        return animalService.createAnimal(animal);
    }

}
