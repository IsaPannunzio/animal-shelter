package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.model.collection.Voluntario;
import com.ibm.animalshelter.repository.VoluntarioRepository;
import com.ibm.animalshelter.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @Autowired
    VoluntarioService voluntarioService;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.controller");

    @GetMapping
    public ResponseEntity<List<Voluntario>> obterTodos() {

        logger.info("Busca por todos os voluntários no banco de dados realizada");
        List<Voluntario> lista = voluntarioService.obterTodos();

        if (lista.isEmpty()) {
            logger.info("Não há nenhum voluntário no banco de dados");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Voluntários retornados, status Ok");
        return new ResponseEntity<List<Voluntario>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> obterPorCodigo(@PathVariable String id) {

        logger.info("Busca pelo abrigo com ID correspondente no banco de dados realizada");
        if (!voluntarioRepository.existsById(id)) {
            logger.info("Voluntário com ID correspondente não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Voluntario voluntario = voluntarioService.obterPorCodigo(id);
        logger.info("Voluntário retornado, status Ok");
        return new ResponseEntity<Voluntario>(voluntario, HttpStatus.OK);

    }

    @PostMapping("/cadastro")
    public ResponseEntity<Voluntario> salvar(@RequestBody @Valid Voluntario voluntario) {


        if (voluntario == null) {
            logger.info("Corpo vazio, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        voluntarioService.salvar(voluntario);

        logger.info("Voluntário adicionado ao banco de dados");
        return new ResponseEntity<>(voluntario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> atualizar(@Valid @PathVariable String id, @RequestBody Voluntario voluntario) {

        logger.info("Iniciando a atualização do voluntário no banco de dados");
        boolean voluntarioExiste = this.voluntarioRepository.existsById(voluntario.getId());

        if (!voluntarioExiste) {
            logger.info("O voluntário não existe, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        voluntario.setId(id);
        voluntario = voluntarioService.atualizar(voluntario);

        logger.info("Voluntário atualizado, staus OK");
        return new ResponseEntity<>(voluntario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!voluntarioRepository.existsById(id)) {
            logger.info("O voluntário não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        voluntarioService.deletar(id);
        logger.info("Voluntário deletado do banco de dados");
        return ResponseEntity.noContent().build();
    }


}
