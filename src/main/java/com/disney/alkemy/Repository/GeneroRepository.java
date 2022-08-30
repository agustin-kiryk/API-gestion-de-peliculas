package com.disney.alkemy.Repository;

import com.disney.alkemy.Entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository <GeneroEntity, Long> {
}
