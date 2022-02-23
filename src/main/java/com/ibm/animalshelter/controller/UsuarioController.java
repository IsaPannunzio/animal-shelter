package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.dto.UsuarioDTO;
import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Usuario;
import com.ibm.animalshelter.repository.UsuarioRepository;
import com.ibm.animalshelter.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/usuario")
@Api(value = "API REST Usuário")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.controller");

    @GetMapping
    @Operation(summary = "Retorna todos os usuários cadastrados")
    public ResponseEntity<List<Usuario>> obterTodos() {

        logger.info("Busca por todos os usuários no banco de dados realizada");
        List<Usuario> lista = usuarioService.obterTodos();

        if (lista.isEmpty()) {
            logger.info("Não há nenhum usuário no banco de dados");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Usuários retornados, status Ok");
        return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna o usuário com ID correspondente")
    public ResponseEntity<Usuario> obterPorCodigo(@PathVariable String id) {

        logger.info("Busca pelo usuário com ID correspondente no banco de dados realizada");
        if (!usuarioRepository.existsById(id)) {
            logger.info("Usuário com ID correspondente não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Usuario usuario = usuarioService.obterPorCodigo(id);
        logger.info("Usuário retornado, status Ok");
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }

    @PostMapping("/admin/cadastro")
    @Operation(summary = "Salva o usuário no banco de dados")
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid UsuarioDTO dto) {


        if (dto == null) {
            logger.info("Corpo vazio, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioService.salvar(dto.transformaParaObjeto());

        logger.info("Usuário adicionado ao banco de dados");
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    @Operation(summary = "Atualiza o usuário com ID correspondente")
    public ResponseEntity<Usuario> atualizar(@Valid @PathVariable String id, @RequestBody UsuarioDTO dto) {

        logger.info("Iniciando a atualização do usuário no banco de dados");
        boolean usuarioExiste = this.usuarioRepository.existsById(dto.getId());

        if (!usuarioExiste) {
            logger.info("O usuário não existe, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioService.atualizar(dto.transformaParaObjeto());

        logger.info("Usuário atualizado, staus OK");
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    @Operation(summary = "Deleta o usuário com ID correspondente")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!usuarioRepository.existsById(id)) {
            logger.info("O usuário não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.deletar(id);
        logger.info("Usuário deletado do banco de dados");
        return ResponseEntity.noContent().build();
    }

}
