package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Abrigo;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface AbrigoService {

    List<Abrigo> obterTodos();

    Abrigo obterPorCodigo(String id);

    Abrigo salvar(Abrigo abrigo);

    Abrigo atualizar(Abrigo abrigo);

    void deletar(String id);

}
