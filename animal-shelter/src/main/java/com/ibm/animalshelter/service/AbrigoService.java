package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AbrigoService {

    @Autowired
    AbrigoRepository abrigoRepository;

    public Abrigo createAbrigo( Abrigo abrigo) {

        return abrigoRepository.save(abrigo);

    }

}
