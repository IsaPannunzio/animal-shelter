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

@RestController
@RequestMapping("/api/abrigo")
public class AbrigoController {

    @Autowired
    AbrigoRepository abrigoRepository;

    @Autowired
    AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<List<Abrigo>> obterTodos() {

        List<Abrigo> lista = abrigoService.obterTodos();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Abrigo>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abrigo> obterPorCodigo(@PathVariable String id) {

        if (!abrigoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Abrigo abrigo = abrigoService.obterPorCodigo(id);
        return new ResponseEntity<Abrigo>(abrigo, HttpStatus.OK);

    }

    @PostMapping("/cadastro")
    public ResponseEntity<Abrigo> salvar(@RequestBody @Valid Abrigo abrigo) {


        if (abrigo == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abrigoService.salvar(abrigo);

        return new ResponseEntity<>(abrigo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizar(@Valid @PathVariable String id, @RequestBody Abrigo abrigo) {

        boolean abrigoExiste = this.abrigoRepository.existsById(abrigo.getId());

        if (!abrigoExiste) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        abrigo.setId(id);
        abrigo = abrigoService.atualizar(abrigo);

        return new ResponseEntity<>(abrigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!abrigoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        abrigoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
