package com.ibm.animalshelter.service;

import com.ibm.animalshelter.model.collection.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    List<Usuario> obterTodos();

    Usuario obterPorCodigo(String id);

    Usuario salvar(Usuario usuario);

    Usuario atualizar(Usuario usuario);

    void deletar(String id);
}
