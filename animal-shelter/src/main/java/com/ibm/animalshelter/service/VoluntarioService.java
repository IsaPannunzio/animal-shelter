package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Voluntario;
import com.ibm.animalshelter.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioService {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    public Voluntario createVoluntario(Voluntario voluntario) {

        return voluntarioRepository.save(voluntario);

    }
}
