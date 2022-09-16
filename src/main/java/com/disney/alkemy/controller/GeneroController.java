package com.disney.alkemy.controller;

import com.disney.alkemy.dto.GeneroDTO;
import com.disney.alkemy.service.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("genre")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generos = generoService.getAllgeneros();
        return ResponseEntity.ok().body(generos);

    }
    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> getDetailsById (@Valid @PathVariable Long id) {
        GeneroDTO genero = generoService.getDetailsById(id);
        return ResponseEntity.ok(genero);
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> save(@Valid @RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        this.generoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> update(@Valid @PathVariable Long id, @RequestBody GeneroDTO genero){
        GeneroDTO result = generoService.update(id,genero);
        return ResponseEntity.ok(result);

    }

}
