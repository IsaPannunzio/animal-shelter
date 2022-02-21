package com.ibm.animalshelter.service.service.impl;

import com.ibm.animalshelter.model.collection.Usuario;
import com.ibm.animalshelter.repository.UsuarioRepository;
import com.ibm.animalshelter.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.service.impl");

    @Override
    public List<Usuario> obterTodos() {

        logger.info("Busca por todos os usuários no banco de dados realizada");
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obterPorCodigo(String id) {

        logger.info("Busca pelo usuário com ID correspondente no banco de dados realizada");
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario salvar(Usuario usuario) {

        logger.info("Usuário adicionado ao banco de dados");
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Usuario usuario) {

        logger.info("Informações de usuário atualizadas no banco de dados");
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(String id) {

        logger.info("Usuário deletado do banco de dados");
        this.usuarioRepository.deleteById(id);
    }
}
