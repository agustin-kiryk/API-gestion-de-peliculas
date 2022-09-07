package com.disney.alkemy.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table( name= "personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause= "deleted=false")
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;
    private boolean deleted = Boolean.FALSE;
// Creo personajes solamente sin asignar peliculas ni genero
    @ManyToMany(mappedBy = "personajes") // TODO: SAQUE CASCADA
    private List<PeliculaEntity> peliculas = new ArrayList<>();






}
