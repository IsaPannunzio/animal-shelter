package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.repository.AnimalRepository;
import com.ibm.animalshelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public List<Animal> obterTodos() {

        return animalRepository.findAll();
    }

    @Override
    public Animal obterPorCodigo(String id) {


        return animalRepository.findById(id).get();
    }

    @Override
    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

        @Override
        public Animal atualizar(Animal animal) {

            return this.animalRepository.save(animal);
        }

        @Override
        public void deletar(String id) {
            this.animalRepository.deleteById(id);
        }

    }

