package com.disney.alkemy.service;

import com.disney.alkemy.dto.PersonajeAuxDTO;
import com.disney.alkemy.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDTO save (PersonajeDTO dto);

    List<PersonajeAuxDTO> getByFilters(String nombre, Long edad, Set<Long> peliculas);

    void delete(Long id);

    List<PersonajeDTO> getAllpersonajes();


    PersonajeDTO getDetailsById(Long id);

    PersonajeDTO update(Long id, PersonajeDTO personaje);

}
