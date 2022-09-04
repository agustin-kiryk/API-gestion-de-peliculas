package com.disney.alkemy.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pelicula" )
@Getter
@Setter

public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate FechaCreacion;

    private Long Calificacion;

    @ManyToOne(fetch = FetchType.EAGER) // TODO : SACO CASCADA

    @JoinColumn(name = "genero_id", insertable = false, updatable = false )
    private GeneroEntity genero;

        //TODO: VER NULLABLE POR SI QUIERO AGREGAR PELI SIN GENERO
    @Column(name= "genero_id", nullable = false)
    private Long generoId;

        // Cuando creo una pelicula puedo agregar varios personajes, pelicula engloba  a personajes//
    @ManyToMany(
            cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
             })
    @JoinTable(
            name= "personaje_pelicula",
            joinColumns = @JoinColumn(name= "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id")
    )
    private Set<PersonajeEntity> personajes = new HashSet<>();


    public void addPersonaje(PersonajeEntity personaje) {
        this.personajes.add(personaje);
    }

    public void removePersonaje(PersonajeEntity personaje) {
        this.personajes.remove(personaje);
    }

}
