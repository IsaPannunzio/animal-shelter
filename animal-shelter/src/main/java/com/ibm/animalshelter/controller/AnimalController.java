package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.repository.AnimalRepository;
import com.ibm.animalshelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> obterTodos() {

        List<Animal> lista = animalService.obterTodos();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Animal>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> obterPorCodigo(@PathVariable String id) {

        if (!animalRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Animal animal = animalService.obterPorCodigo(id);
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);

    }

    @PostMapping("/cadastro")
    public ResponseEntity<Animal> salvar(@RequestBody @Valid Animal animal) {


        if (animal == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        animalService.salvar(animal);

        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@Valid @PathVariable String id, @RequestBody Animal animal) {

        boolean animalExiste = this.animalRepository.existsById(animal.getId());

        if (!animalExiste) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        animal.setId(id);
        animal = animalService.atualizar(animal);

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!animalRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
