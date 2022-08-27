package com.disney.disney.Service;

import com.disney.disney.DTO.GeneroDTO;

import java.util.List;

public interface GeneroService {
    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAllgeneros();


    void delete(Long id);
}
