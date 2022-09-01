package com.disney.alkemy.Service;

import com.disney.alkemy.DTO.PersonajeAuxDTO;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Entity.PersonajeEntity;

import java.util.List;
import java.util.Set;

public interface PersonajeService {
    PersonajeDTO save (PersonajeDTO dto);



    List<PersonajeDTO> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculas);

    void delete(Long id);

    List<PersonajeAuxDTO> getAllpersonajes();

    PersonajeEntity getEntityById(Long idPersonaje);

    PersonajeDTO getDetailsById(Long id);



}
