package com.disney.alkemy.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.swing.*;
import java.lang.reflect.Type;
import java.util.*;

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
    private Double peso;
    private String historia;


    @ManyToMany(mappedBy = "personajes")
    private List<PeliculaEntity> peliculas = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PersonajeEntity)) {
            return false;
        } else {
            PersonajeEntity personajeEntity = (PersonajeEntity) obj;
            if (this.getId() != null) {
                return this.getId().equals(personajeEntity.getId());

            } else {
                return false;
            }
        }
    }
}





