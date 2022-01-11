package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.repository.AbrigoRepository;
import com.ibm.animalshelter.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/abrigo")
public class AbrigoController {

    @Autowired
    AbrigoRepository abrigoRepository;

    @Autowired
    AbrigoService abrigoService;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.controller");

    @GetMapping
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

    @PostMapping("/cadastro")
    public ResponseEntity<Abrigo> salvar(@RequestBody @Valid Abrigo abrigo) {


        if (abrigo == null) {
            logger.info("Corpo vazio, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abrigoService.salvar(abrigo);

        logger.info("Abrigo adicionado ao banco de dados");
        return new ResponseEntity<>(abrigo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizar(@Valid @PathVariable String id, @RequestBody Abrigo abrigo) {

        logger.info("Iniciando a atualização do abrigo no banco de dados");
        boolean abrigoExiste = this.abrigoRepository.existsById(abrigo.getId());

        if (!abrigoExiste) {
            logger.info("O abrigo não existe, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abrigo.setId(id);
        abrigo = abrigoService.atualizar(abrigo);

        logger.info("Abrigo atualizado, staus OK");
        return new ResponseEntity<>(abrigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
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
