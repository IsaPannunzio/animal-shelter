package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimalService {

    List<Animal> obterTodos();

    Animal obterPorCodigo(String id);

    Animal salvar(Animal animal);

    Animal atualizar(Animal animal);

    void deletar(String id);

}
