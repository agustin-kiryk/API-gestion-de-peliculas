package com.disney.alkemy.Service;

import com.disney.alkemy.DTO.PersonajeDTO;

import java.util.List;

public interface PersonajeService {
    PersonajeDTO save (PersonajeDTO dto);

    void delete(Long id);

    List<PersonajeDTO> getAllpersonajes();
}
