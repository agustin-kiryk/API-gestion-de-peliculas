package com.disney.alkemy.service;

import com.disney.alkemy.dto.GeneroDTO;

import java.util.List;

public interface GeneroService {
    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAllgeneros();

    void delete(Long id);

    GeneroDTO getDetailsById(Long id);

    GeneroDTO update(Long id, GeneroDTO genero);
}
