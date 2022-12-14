package com.disney.alkemy.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class GeneroDTO {
    private Long id;
    @NotEmpty
    private String nombre;
    private String imagen;



}
