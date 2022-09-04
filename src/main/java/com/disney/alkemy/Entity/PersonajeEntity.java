package com.disney.alkemy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table( name= "personaje")
@Getter
@Setter

public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;

// Creo personajes solamente sin asignar peliculas ni genero
    @ManyToMany(mappedBy = "personajes") // TODO: SAQUE CASCADA
    private List<PeliculaEntity> peliculas = new ArrayList<>();





}
