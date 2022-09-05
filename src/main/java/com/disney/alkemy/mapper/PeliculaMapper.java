package com.disney.alkemy.mapper;

import com.disney.alkemy.DTO.PeliculaAuxDTO;
import com.disney.alkemy.DTO.PeliculaDTO;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Entity.PeliculaEntity;
import com.disney.alkemy.Entity.PersonajeEntity;
import com.disney.alkemy.Repository.GeneroRepository;
import com.disney.alkemy.Repository.PeliculaRepository;
import com.disney.alkemy.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {
    @Autowired
    private PersonajeMapper personajeMapper;
   /** @Autowired  //TODO: SACO @LAZY DE atributos en clase peliculamapper
    public PeliculaMapper( PersonajeMapper personajeMapper) {

        this.personajeMapper = personajeMapper;
    }**/
   @Autowired
   private PersonajeRepository personajeRepository;
   @Autowired
   private PeliculaRepository peliculaRepository;
   @Autowired
   private GeneroMapper generoMapper;
   @Autowired
   private GeneroRepository generoRepository;
    private LocalDate stringToLocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
    public void peliculaEntityRefreshValues(PeliculaEntity entity, PeliculaDTO dto) {
        entity.setImagen(dto.getImagen());
        entity.setTitulo(dto.getTitulo());
        entity.setFechaCreacion(this.stringToLocalDate(dto.getFechaCreacion()));
        entity.setCalificacion(dto.getCalificacion());
        entity.setGeneroId(dto.getGeneroId());
    }

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto) {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaCreacion(this.stringToLocalDate(dto.getFechaCreacion()));
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());
        Set<PersonajeEntity>personajes = personajeMapper.personajeDTOList2Entity(dto.getPersonajes());
        peliculaEntity.setPersonajes(personajes);
        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, Boolean loadPersonajes) {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaCreacion(entity.getFechaCreacion().toString());
        dto.setCalificacion(entity.getCalificacion());
        dto.setGeneroId(entity.getGeneroId());
        if(loadPersonajes) {
            List<PersonajeDTO> personajeDTOS = this.personajeMapper.personajeEntitySet2DTOList(entity.getPersonajes(), false);
            dto.setPersonajes(personajeDTOS);
        }

        return dto;
    }

    public List<PeliculaDTO> peliculasEntityList2DTOList(List<PeliculaEntity> entities, Boolean loadPersonajes) {
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (PeliculaEntity entity : entities) {
            dtos.add(this.peliculaEntity2DTO(entity, loadPersonajes));
        }
        return dtos;
    }

    public List<PeliculaDTO> peliculaEntitySet2DTOList(Collection<PeliculaEntity> entities, boolean loadPersonajes) {
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (PeliculaEntity entity : entities) {
            dtos.add(this.peliculaEntity2DTO(entity, loadPersonajes));
        }
        return dtos;
    }

    public List<PeliculaAuxDTO> peliculasEntityList2AuxDTOList(List<PeliculaEntity> entities) {
        List<PeliculaAuxDTO> dtos = new ArrayList<>();
        PeliculaAuxDTO auxDTO;
        for (PeliculaEntity entity : entities) {
            auxDTO = new PeliculaAuxDTO();
            auxDTO.setId(entity.getId());
            auxDTO.setImagen(entity.getImagen());
            auxDTO.setTitulo(entity.getTitulo());
            dtos.add(auxDTO);
        }
        return dtos;
    }


}
