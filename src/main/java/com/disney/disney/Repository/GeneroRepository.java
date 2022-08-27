package com.disney.disney.Repository;

import com.disney.disney.Entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository <GeneroEntity, Long> {
}
