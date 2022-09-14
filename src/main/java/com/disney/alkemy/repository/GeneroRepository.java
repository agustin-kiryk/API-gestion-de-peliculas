package com.disney.alkemy.repository;

import com.disney.alkemy.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository <GeneroEntity, Long> {
}
