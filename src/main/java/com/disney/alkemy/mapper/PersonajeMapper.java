package com.disney.alkemy.mapper;

import com.disney.alkemy.dto.PeliculaDTO;
import com.disney.alkemy.dto.PersonajeAuxDTO;
import com.disney.alkemy.dto.PersonajeDTO;
import com.disney.alkemy.entity.PersonajeEntity;
import com.disney.alkemy.repository.PeliculaRepository;
import com.disney.alkemy.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Set;
@Component
public class PersonajeMapper {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    PeliculaRepository peliculaRepository;

    public void personajeEntityRefreshValues(PersonajeEntity entity, PersonajeDTO dto) {
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
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
        dto.setHistoria(entity.getHistoria());
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

    public List<PersonajeDTO> personajeEntitySet2DTOList(Collection<PersonajeEntity> entities, boolean loadPeliculas) {
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(this.personajeEntity2DTO(entity, false));
        }
        return dtos;
    }

    public List<PersonajeAuxDTO> personajeEntitySet2AuxDTOList(Collection<PersonajeEntity> entities) {
        List<PersonajeAuxDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(personajeEntity2AuxDTO(entity));
        }
        return dtos;
    }
    public PersonajeAuxDTO personajeEntity2AuxDTO (PersonajeEntity entity){
        PersonajeAuxDTO dto = new PersonajeAuxDTO();
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        return dto;
    }

}
