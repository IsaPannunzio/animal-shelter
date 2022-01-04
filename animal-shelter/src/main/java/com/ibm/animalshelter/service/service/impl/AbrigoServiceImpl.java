package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.repository.AbrigoRepository;
import com.ibm.animalshelter.service.AbrigoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AbrigoServiceImpl implements AbrigoService {

    @Autowired
    AbrigoRepository abrigoRepository;

    @Override
    public List<Abrigo> obterTodos() {

        return abrigoRepository.findAll();
    }

    @Override
    public Abrigo obterPorCodigo(String id) {


        return abrigoRepository.findById(id).get();
    }

    @Override
    public Abrigo salvar(Abrigo abrigo) {
        return abrigoRepository.save(abrigo);
    }

    @Override
    public Abrigo atualizar(Abrigo abrigo) {

        return this.abrigoRepository.save(abrigo);
    }

    @Override
    public void deletar(String id) {
        this.abrigoRepository.deleteById(id);
    }

}

