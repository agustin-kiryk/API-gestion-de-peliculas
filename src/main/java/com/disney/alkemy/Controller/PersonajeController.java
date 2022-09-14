package com.disney.alkemy.Controller;


import com.disney.alkemy.DTO.PersonajeAuxDTO;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(
            @Valid @PathVariable Long id, @RequestBody PersonajeDTO personaje) {
        PersonajeDTO result = this.personajeService.update(id, personaje);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@Valid @RequestBody PersonajeDTO personaje) {
        PersonajeDTO personajeSaved = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getDetailsById(@Valid @PathVariable Long id) {
        PersonajeDTO personaje = this.personajeService.getDetailsById(id);
        return ResponseEntity.ok(personaje);
    }

    @GetMapping
    ResponseEntity<List<PersonajeAuxDTO>> getByFilters(
            @Valid @RequestParam(value = "name", required = false) String nombre,
            @Valid @RequestParam(value = "age", required = false) Long edad,
            @Valid @RequestParam(value = "movies", required = false) Set<Long> peliculas
    ) {
        List<PersonajeAuxDTO> personajes = this.personajeService.getByFilters(nombre, edad, peliculas);
        return ResponseEntity.ok(personajes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        this.personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}



