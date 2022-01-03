package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal createAnimal(Animal animal) {

        return animalRepository.save(animal);

    }
}
