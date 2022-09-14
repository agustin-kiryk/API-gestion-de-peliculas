package com.disney.alkemy.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pelicula" )
@Getter
@Setter
@SQLDelete(sql="UPDATE pelicula SET deleted= true WHERE id=?")
@Where(clause="deleted=false")
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long Calificacion;

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "genero_id", insertable = false, updatable = false )
    private GeneroEntity genero;


    @Column(name= "genero_id", nullable = false)
    private Long generoId;

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
    private boolean deleted = Boolean.FALSE;

    public void addPersonaje(PersonajeEntity personaje) {
        this.personajes.add(personaje);
    }

    public void removePersonaje (PersonajeEntity personaje) {
       this.personajes.remove(personaje);
    }


}
