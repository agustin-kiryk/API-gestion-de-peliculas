package com.disney.alkemy.Controller;

import com.disney.alkemy.DTO.GeneroDTO;
import com.disney.alkemy.Service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    /*   @RequestMapping(value = "prueba1")
    public List<String> prueba() {
        return List.of("manzana", "kiwi", "banana");
    }    */
    @Autowired
    private GeneroService generoService;

    //Traer Generos//

    @GetMapping("/all")
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generos = generoService.getAllgeneros();
        return ResponseEntity.ok().body(generos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> getDetailsById (@PathVariable Long id) {
        GeneroDTO genero = generoService.getDetailsById(id);
        return ResponseEntity.ok(genero);
    }


    /*guardar genero*/
    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //Borrar generos//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.generoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Actualizar Generos//

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> update(@PathVariable Long id, @RequestBody GeneroDTO genero){
        GeneroDTO result = generoService.update(id,genero);
        return ResponseEntity.ok(result);

    }


}