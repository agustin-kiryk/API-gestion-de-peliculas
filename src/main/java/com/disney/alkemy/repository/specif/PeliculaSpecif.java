package com.disney.alkemy.repository.specif;

import com.disney.alkemy.dto.PeliculaFiltersDTO;
import com.disney.alkemy.entity.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class PeliculaSpecif {
    public Specification<PeliculaEntity> getByFilters(PeliculaFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getTitulo())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(
                                        root.get("titulo")),
                                "%" + filtersDTO.getTitulo().toLowerCase() + "%"
                        )
                );
            }

            if (!Objects.isNull(filtersDTO.getGeneroId())) {
                predicates.add(
                        criteriaBuilder.equal(root.get("genero"), filtersDTO.getGeneroId())
                );
            }

            //remueve duplicados
            query.distinct(true);

            //resolver orden
            String orderByField = "fechaCreacion";
            query.orderBy(
                    filtersDTO.isAsc() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))

            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}


