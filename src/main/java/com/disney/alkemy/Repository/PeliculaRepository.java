package com.disney.alkemy.Repository;

import com.disney.alkemy.Entity.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    List<PeliculaEntity> findAll(Specification<PeliculaEntity> spec);


}
