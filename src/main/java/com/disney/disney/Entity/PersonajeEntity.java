package com.disney.disney.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<PeliculasEntity> peliculas= new ArrayList<>();





}
