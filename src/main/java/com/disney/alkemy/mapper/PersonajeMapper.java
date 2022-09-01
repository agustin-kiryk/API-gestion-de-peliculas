package com.disney.alkemy.mapper;

import com.disney.alkemy.DTO.PeliculaDTO;
import com.disney.alkemy.DTO.PersonajeAuxDTO;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonajeMapper {
    @Autowired
    private PeliculaMapper peliculaMapper;

    public void personajeEntityRefreshValues(PersonajeEntity entity, PersonajeDTO dto) {
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());//peso historia
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());



    }

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity entity = new PersonajeEntity();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());
        return entity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPeliculas) {
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        if (loadPeliculas) {
            List<PeliculaDTO> peliculasDTOS = this.peliculaMapper.peliculasEntityList2DTOList(entity.getPeliculas(), false);
            dto.setPeliculas(peliculasDTOS);
        }
        return dto;
    }

    public Set<PersonajeEntity> personajeDTOList2Entity(List<PersonajeDTO> dtos) {
        Set<PersonajeEntity> entities = new HashSet<>();
        for (PersonajeDTO dto : dtos) {
            entities.add(this.personajeDTO2Entity(dto));
        }

        return entities;
    }

    /**
     * @param entities (Set or List)
     * @param loadCities
     */
    public List<PersonajeDTO> personajeEntitySet2DTOList(Collection<PersonajeEntity> entities, boolean loadPeliculas) {
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(this.personajeEntity2DTO(entity, false));
        }
        return dtos;
    }

    public List<PersonajeAuxDTO> personajeEntitySet2AuxDTOList(Collection<PersonajeEntity> entities) {
        List<PersonajeAuxDTO> dtos = new ArrayList<>();
        PersonajeAuxDTO auxDTO;
        for (PersonajeEntity entity : entities) {
            auxDTO = new PersonajeAuxDTO();
            auxDTO.setId(entity.getId());
            auxDTO.setImagen(entity.getImagen());
            auxDTO.setNombre(entity.getNombre());
            dtos.add(auxDTO);
        }
        return dtos;
    }




}
