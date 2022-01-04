package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Voluntario;
import com.ibm.animalshelter.repository.VoluntarioRepository;
import com.ibm.animalshelter.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @Override
    public List<Voluntario> obterTodos() {

        return voluntarioRepository.findAll();
    }

    @Override
    public Voluntario obterPorCodigo(String id) {


        return voluntarioRepository.findById(id).get();
    }

    @Override
    public Voluntario salvar(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }


        @Override
        public Voluntario atualizar(Voluntario voluntario) {

            return this.voluntarioRepository.save(voluntario);
        }

        @Override
        public void deletar(String id) {
            this.voluntarioRepository.deleteById(id);
        }

    }

