package com.disney.alkemy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class PersonajeFiltersDTO {
    private String nombre;
    private Long edad;
    private Set<Long> peliculas;
}
