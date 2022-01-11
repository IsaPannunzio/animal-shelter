package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.repository.AnimalRepository;
import com.ibm.animalshelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.service.impl");

    @Override
    public List<Animal> obterTodos() {

        logger.info("Busca por todos os animais no banco de dados realizada");
        return animalRepository.findAll();
    }

    @Override
    public Animal obterPorCodigo(String id) {

        logger.info("Busca pelo animal com ID correspondente no banco de dados realizada");
        return animalRepository.findById(id).get();
    }

    @Override
    public Animal salvar(Animal animal) {

        logger.info("Animal adicionado ao banco de dados");
        return animalRepository.save(animal);
    }

        @Override
        public Animal atualizar(Animal animal) {

        logger.info("Informações de animal atualizadas no banco de dados");
        return this.animalRepository.save(animal);
        }

        @Override
        public void deletar(String id) {

        logger.info("Animal deletado do banco de dados");
        this.animalRepository.deleteById(id);
        }

    }

