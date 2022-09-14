package com.disney.alkemy.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;
@Getter
@Setter
public class PersonajeDTO {

    private Long id;
    private String imagen;
    @NotEmpty
    private String nombre;
    @Positive
    private Long edad;
    @Positive
    private Double peso;
    private String historia;
    private List<PeliculaDTO> peliculas;


}
