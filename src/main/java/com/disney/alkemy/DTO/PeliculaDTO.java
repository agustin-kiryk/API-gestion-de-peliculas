package com.disney.alkemy.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PeliculaDTO {

    private Long id;
    private String imagen;
    @NotEmpty
    private String titulo;
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))", message="Formato de fecha inválido")
    private String fechaCreacion;
    @Min(value=1, message = "El minimo de calificacion es 1 (uno)")
    @Max(value = 5, message = "El maximo de calificacion es 5 (cinco)")
    private Long calificacion;
    @NotEmpty(message = "Debe ingresar un genero, si el genero no existe por favor cree uno nuevo")
    private Long generoId; //todo: **** CAMBIO STRING GENERO POR QUE ME DA ERROR EN EL MAPPER y service DE PELICULA ******
    private List<PersonajeDTO> personajes;




}
