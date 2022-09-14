package com.disney.alkemy.Controller;

import com.disney.alkemy.DTO.PeliculaAuxDTO;
import com.disney.alkemy.DTO.PeliculaDTO;
import com.disney.alkemy.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")

public class PeliculaController {

    private PeliculaService peliculaService;
    @Autowired
    PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getDetailsById(@Valid @PathVariable Long id) {
        PeliculaDTO pelicula = this.peliculaService.getDetailsById(id);
        return ResponseEntity.ok(pelicula);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaAuxDTO>> getDetailsByFilters(
          @Valid @RequestParam(value="name",required = false) String titulo,
          @Valid @RequestParam(value ="genre",required = false) Long genero,
          @Valid @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<PeliculaAuxDTO> peliculas = this.peliculaService.getDetailsByFilters(titulo, genero, order);
        return ResponseEntity.ok(peliculas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update (
            @Valid @PathVariable Long id, @RequestBody PeliculaDTO pelicula) {
        PeliculaDTO result = this.peliculaService.update(id, pelicula);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(
           @Valid @RequestBody PeliculaDTO pelicula) {
        PeliculaDTO result = peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/{id}/characters/{idPersonaje}")
        public ResponseEntity<PeliculaDTO> add(
          @Valid @PathVariable("id") Long id,
          @Valid @PathVariable("idPersonaje") Long idPersonaje){
        this.peliculaService.addPersonaje(id, idPersonaje);
        PeliculaDTO dto = this.peliculaService.addPersonaje(id,idPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}/characters/{idPersonaje}")
    public ResponseEntity<PeliculaDTO> removePersonaje(
          @Valid   @PathVariable("id") Long id,
          @Valid   @PathVariable("idPersonaje") Long idPersonaje) {
        PeliculaDTO dto = this.peliculaService.removePersonaje(id, idPersonaje);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        this.peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
