package com.disney.alkemy.mapper;

import org.springframework.stereotype.Component;

@Component
public class PersonajeMapper {
    private PeliculaMapper peliculaMapper;

    public PersonajeMapper(PeliculaMapper peliculaMapper) {
        this.peliculaMapper = peliculaMapper;
    }


/**
    public PersonajeEntity personajedto2Entity (PersonajeDTO dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
       // personajeEntity.setPeliculas(dto.getPelicula());
        return personajeEntity;
    }
    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity){
       PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        //dto.setPelicula(entity.getPeliculas());
        return dto;


    }

    public List<PersonajeDTO> personajeEntityList2DTOList (List<PersonajeEntity> entities){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(this.personajeEntity2DTO(entity));
        }
        return dtos;
    }
**/

}
