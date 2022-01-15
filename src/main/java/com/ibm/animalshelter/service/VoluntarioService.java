package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Voluntario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoluntarioService {

    List<Voluntario> obterTodos();

    Voluntario obterPorCodigo(String id);

    Voluntario salvar(Voluntario voluntario);

    Voluntario atualizar(Voluntario voluntario);

    void deletar(String id);
}
