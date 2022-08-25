package com.disney.disney.Entity;

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

public class PeliculasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyy/mm/dd")
    private LocalDate FechaCreacion;

    private Long Calificacion;

        //inicializacion temprana//
        //Si pido una pelicula me va a venir con su genero//
        // Con cascade all aplico los cambios a los demas atributos//
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)


         // Se usa false por que SOLO LO USO PARA PEDIR INFO //
    @JoinColumn(name = "genero_id", insertable = false, updatable = false )
    private GeneroEntity genero;

        //Con esta columna cuando quiero crear una pelicula le paso un id de genero y se crea en ese lugar//
        //guardo y actualizo//
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
    private Set<PersonajeEntity> personaje = new HashSet<>();









}
