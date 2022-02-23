package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.dto.AbrigoDTO;
import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.repository.AbrigoRepository;
import com.ibm.animalshelter.service.AbrigoService;
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
@RequestMapping("/api/abrigo")
@Api(value = "API REST Abrigo")
@CrossOrigin(origins = "*")
public class AbrigoController {

    @Autowired
    AbrigoRepository abrigoRepository;

    @Autowired
    AbrigoService abrigoService;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.controller");

    @GetMapping
    @Operation(summary = "Retorna todos os abrigos cadastrados")
    public ResponseEntity<List<Abrigo>> obterTodos() {

        logger.info("Busca por todos os abrigos no banco de dados realizada");
        List<Abrigo> lista = abrigoService.obterTodos();

        if (lista.isEmpty()) {
            logger.info("Não há nenhum abrigo no banco de dados");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Abrigos retornados, status Ok");
        return new ResponseEntity<List<Abrigo>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna o abrigo com ID correspondente")
    public ResponseEntity<Abrigo> obterPorCodigo(@PathVariable String id) {

        logger.info("Busca pelo abrigo com ID correspondente no banco de dados realizada");
        if (!abrigoRepository.existsById(id)) {
            logger.info("Abrigo com ID correspondente não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Abrigo abrigo = abrigoService.obterPorCodigo(id);
        logger.info("Abrigo retornado, status Ok");
        return new ResponseEntity<Abrigo>(abrigo, HttpStatus.OK);

    }

    @PostMapping("/admin/cadastro")
    @Operation(summary = "Salva o abrigo no banco de dados")
    public ResponseEntity<Abrigo> salvar(@RequestBody @Valid AbrigoDTO dto) {

        if (dto == null) {
            logger.info("Corpo vazio, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Abrigo abrigo = abrigoService.salvar(dto.transformaParaObjeto());

        logger.info("Abrigo adicionado ao banco de dados");
        return new ResponseEntity<>(abrigo, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    @Operation(summary = "Atualiza o abrigo com ID correspondente")
    public ResponseEntity<Abrigo> atualizar(@Valid @PathVariable String id, @RequestBody AbrigoDTO dto) {

        logger.info("Iniciando a atualização do abrigo no banco de dados");
        boolean abrigoExiste = this.abrigoRepository.existsById(dto.getId());

        if (!abrigoExiste) {
            logger.info("O abrigo não existe, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        Abrigo abrigo = abrigoService.atualizar(dto.transformaParaObjeto());

        logger.info("Abrigo atualizado, staus OK");
        return new ResponseEntity<>(abrigo, HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    @Operation(summary = "Deleta o abrigo com ID correspondente")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!abrigoRepository.existsById(id)) {
            logger.info("O abrigo não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        abrigoService.deletar(id);
        logger.info("Abrigo deletado do banco de dados");
        return ResponseEntity.noContent().build();
    }

}
