package com.ibm.animalshelter.controller;

import com.ibm.animalshelter.model.collection.Animal;
import com.ibm.animalshelter.repository.AnimalRepository;
import com.ibm.animalshelter.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/animal")
@Api(value = "API REST Animal")
@CrossOrigin(origins = "*")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AnimalService animalService;
    Logger logger = Logger.getLogger("com.ibm.animalshelter.controller");

    @GetMapping
    @ApiOperation(value = "Retorna todos os animais cadastrados")
    public ResponseEntity<List<Animal>> obterTodos() {

        logger.info("Busca por todos os animais no banco de dados realizada");
        List<Animal> lista = animalService.obterTodos();

        if (lista.isEmpty()) {
            logger.info("Não há nenhum animal no banco de dados");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Animais retornados, status Ok");
        return new ResponseEntity<List<Animal>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o animal com ID correspondente")
    public ResponseEntity<Animal> obterPorCodigo(@PathVariable String id) {

        logger.info("Busca pelo animal com ID correspondente no banco de dados realizada");
        if (!animalRepository.existsById(id)) {
            logger.info("Animal com ID correspondente não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Animal animal = animalService.obterPorCodigo(id);
        logger.info("Animal retornado, status Ok");
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);

    }

    @PostMapping("/cadastro")
    @ApiOperation(value = "Salva o animal no banco de dados")
    public ResponseEntity<Animal> salvar(@RequestBody @Valid Animal animal) {


        if (animal == null) {
            logger.info("Corpo vazio, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        animalService.salvar(animal);

        logger.info("Animal adicionado ao banco de dados");
        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza o animal com ID correspondente")
    public ResponseEntity<Animal> atualizar(@Valid @PathVariable String id, @RequestBody Animal animal) {

        logger.info("Iniciando a atualização do animal no banco de dados");
        boolean animalExiste = this.animalRepository.existsById(animal.getId());

        if (!animalExiste) {
            logger.info("O animal não existe, retorna BAD REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        animal.setId(id);
        animal = animalService.atualizar(animal);

        logger.info("Animal atualizado, staus OK");
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta o animal com ID correspondente")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        if (!animalRepository.existsById(id)) {
            logger.info("O animal não existe, retorna NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        animalService.deletar(id);
        logger.info("Animal deletado do banco de dados");
        return ResponseEntity.noContent().build();
    }

}
