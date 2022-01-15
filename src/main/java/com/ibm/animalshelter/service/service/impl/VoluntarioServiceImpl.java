package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Voluntario;
import com.ibm.animalshelter.repository.VoluntarioRepository;
import com.ibm.animalshelter.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    @Autowired
    VoluntarioRepository voluntarioRepository;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.service.impl");

    @Override
    public List<Voluntario> obterTodos() {

        logger.info("Realizando a busca por todos os voluntários no banco de dados");
        return voluntarioRepository.findAll();
    }

    @Override
    public Voluntario obterPorCodigo(String id) {

        logger.info("Realizando a busca pelo voluntário com ID correspondente no banco de dados");
        return voluntarioRepository.findById(id).get();
    }

    @Override
    public Voluntario salvar(Voluntario voluntario) {

        logger.info("Voluntário adicionado ao banco de dados");
        return voluntarioRepository.save(voluntario);
    }


        @Override
        public Voluntario atualizar(Voluntario voluntario) {

        logger.info("Informações de voluntário atualizadas no banco de dados");
        return this.voluntarioRepository.save(voluntario);
        }

        @Override
        public void deletar(String id) {

        logger.info("Voluntário deletado do banco de dados");
        this.voluntarioRepository.deleteById(id);
        }

    }

