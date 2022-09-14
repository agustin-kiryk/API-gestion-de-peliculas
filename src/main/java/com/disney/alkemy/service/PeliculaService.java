package com.disney.alkemy.service;

import com.disney.alkemy.dto.PeliculaAuxDTO;
import com.disney.alkemy.dto.PeliculaDTO;

import java.util.List;

public interface PeliculaService {

    List<PeliculaAuxDTO> getAll();

    PeliculaDTO getDetailsById(Long id);

    List<PeliculaAuxDTO> getDetailsByFilters(String titulo, Long genero, String order);

    PeliculaDTO update(Long id, PeliculaDTO pelicula);

    PeliculaDTO save(PeliculaDTO pelicula);

    PeliculaDTO addPersonaje(Long id, Long idPersonaje);

    PeliculaDTO removePersonaje(Long id, Long idPersonaje);

    void delete(Long id);
}
