package com.disney.alkemy.Repository;

import com.disney.alkemy.Entity.PeliculaEntity;
import com.disney.alkemy.Entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {
    List<PersonajeEntity> findAll(Specification<PersonajeEntity> spec);
}
