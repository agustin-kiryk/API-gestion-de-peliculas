package com.disney.alkemy.Repository.Specif;
import com.disney.alkemy.DTO.PersonajeFiltersDTO;
import com.disney.alkemy.Entity.PeliculaEntity;
import com.disney.alkemy.Entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonajeSpecif {
    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getNombre())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%")

                );
            }

            if (filtersDTO.getEdad() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.<Integer>get("edad"), filtersDTO.getEdad() )
                );
            }
           /* if (filtersDTO.getPeso() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.<Integer>get("peso"), "%"+filtersDTO.getPeso()+ "%")
                );
            }*/


            if (!CollectionUtils.isEmpty(filtersDTO.getPeliculas())) {
                Join<PeliculaEntity, PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicates.add(peliculasId.in(filtersDTO.getPeliculas()));
            }

            //remove duplicates
            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }}








