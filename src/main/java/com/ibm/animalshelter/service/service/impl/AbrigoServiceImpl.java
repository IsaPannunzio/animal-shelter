package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.dto.AbrigoDTO;
import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.repository.AbrigoRepository;
import com.ibm.animalshelter.service.AbrigoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class AbrigoServiceImpl implements AbrigoService {

    @Autowired
    AbrigoRepository abrigoRepository;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.service.impl");

    @Override
    public List<Abrigo> obterTodos() {

        logger.info("Busca por todos os abrigos no banco de dados realizada");
        return abrigoRepository.findAll();
    }

    @Override
    public Abrigo obterPorCodigo(String id) {

        logger.info("Busca pelo abrigo com ID correspondente no banco de dados realizada");
        return abrigoRepository.findById(id).get();
    }

    @Override
    public Abrigo salvar(Abrigo abrigo) {

        logger.info("Abrigo adicionado ao banco de dados");
        return abrigoRepository.save(abrigo);
    }

    @Override
    public Abrigo atualizar(Abrigo abrigo) {

        logger.info("Informações de abrigo atualizadas no banco de dados");
        return this.abrigoRepository.save(abrigo);
    }

    @Override
    public void deletar(String id) {

        logger.info("Abrigo deletado do banco de dados");
        this.abrigoRepository.deleteById(id);
    }


}

