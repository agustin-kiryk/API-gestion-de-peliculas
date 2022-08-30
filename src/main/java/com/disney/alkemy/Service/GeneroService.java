package com.disney.alkemy.Service;

import com.disney.alkemy.DTO.GeneroDTO;

import java.util.List;

public interface GeneroService {
    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAllgeneros();


    void delete(Long id);

    GeneroDTO getDetailsById(Long id);

    GeneroDTO update(Long id, GeneroDTO genero);
}
