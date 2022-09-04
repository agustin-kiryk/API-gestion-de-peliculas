package com.disney.alkemy.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeliculaDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private String fechaCreacion;
    private Long calificacion;
    private Long generoId; //todo: **** CAMBIO STRING GENERO POR QUE ME DA ERROR EN EL MAPPER y service DE PELICULA ******
    private List<PersonajeDTO> personajes;




}
