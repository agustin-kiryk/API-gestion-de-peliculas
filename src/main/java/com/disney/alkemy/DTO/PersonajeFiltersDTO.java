package com.disney.alkemy.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter

public class PersonajeFiltersDTO {
    private String nombre;
    private Long edad;
    private Long peso;
    private Set<Long> peliculas;
}
