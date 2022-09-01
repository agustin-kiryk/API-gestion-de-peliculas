package com.disney.alkemy.Repository.Specif;

import com.disney.alkemy.DTO.PeliculaFiltersDTO;
import com.disney.alkemy.DTO.PersonajeFiltersDTO;
import com.disney.alkemy.Entity.PeliculaEntity;
import com.disney.alkemy.Entity.PersonajeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class PersonajeSpecif {
    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filtersDTO) {

            return null;


}}


