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

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping
    public ResponseEntity<List<Voluntario>> obterTodos() {

        List<Voluntario> lista = voluntarioService.obterTodos();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Voluntario>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> obterPorCodigo(@PathVariable String id) {

        if (!voluntarioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Voluntario voluntario = voluntarioService.obterPorCodigo(id);
        return new ResponseEntity<Voluntario>(voluntario, HttpStatus.OK);

    }

    @PostMapping("/cadastro")
    public ResponseEntity<Voluntario> salvar(@RequestBody @Valid Voluntario voluntario) {


        if (voluntario == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        voluntarioService.salvar(voluntario);

        return new ResponseEntity<>(voluntario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> atualizar(@Valid @PathVariable String id, @RequestBody Voluntario voluntario) {

        boolean voluntarioExiste = this.voluntarioRepository.existsById(voluntario.getId());

        if (!voluntarioExiste) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        voluntario.setId(id);
        voluntario = voluntarioService.atualizar(voluntario);

        return new ResponseEntity<>(voluntario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!voluntarioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        voluntarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
