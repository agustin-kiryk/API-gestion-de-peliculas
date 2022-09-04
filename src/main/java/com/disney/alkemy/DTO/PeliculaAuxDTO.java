package com.disney.alkemy.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PeliculaAuxDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private String FechaCreacion;



}
