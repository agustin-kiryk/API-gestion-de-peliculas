package com.disney.alkemy.Repository;

import com.disney.alkemy.Entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    List<PeliculaEntity> findAll(Object byFilters);


}
