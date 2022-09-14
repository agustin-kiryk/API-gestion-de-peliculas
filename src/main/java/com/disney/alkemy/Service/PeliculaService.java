package com.disney.alkemy.Service;

import com.disney.alkemy.DTO.PeliculaAuxDTO;
import com.disney.alkemy.DTO.PeliculaDTO;

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
