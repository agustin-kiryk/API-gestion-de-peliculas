package com.disney.alkemy.Service.impl;

import com.disney.alkemy.DTO.PeliculaAuxDTO;
import com.disney.alkemy.DTO.PeliculaDTO;
import com.disney.alkemy.DTO.PeliculaFiltersDTO;
import com.disney.alkemy.Entity.PeliculaEntity;
import com.disney.alkemy.Repository.PeliculaRepository;
import com.disney.alkemy.Repository.Specif.PeliculaSpecif;
import com.disney.alkemy.Service.PeliculaService;
import com.disney.alkemy.Service.PersonajeService;
import com.disney.alkemy.exceptions.ParamNotFound;
import com.disney.alkemy.mapper.PeliculaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    private PeliculaSpecif peliculaSpecif;

    private PeliculaMapper peliculaMapper;

    private PersonajeService personajeService;

    @Autowired
    public PeliculaServiceImpl(
            PeliculaRepository peliculaRepository,
            PeliculaSpecif peliculaSpecif,
            PeliculaMapper peliculaMapper,
            PersonajeService personajeService
    ) {
        this.peliculaRepository = peliculaRepository;
        this.peliculaSpecif = peliculaSpecif;
        this.peliculaMapper = peliculaMapper;
        this.personajeService = personajeService;
    }
    @Override
    public List<PeliculaAuxDTO> getAll() {
        List<PeliculaEntity> entities = peliculaRepository.findAll();
        List<PeliculaAuxDTO> peliculaAuxDTO = peliculaMapper.peliculasEntityList2AuxDTOList(entities);
        return peliculaAuxDTO;

    }

    @Override
    public PeliculaDTO getDetailsById(Long id) {
        Optional<PeliculaEntity> entity = Optional.of(peliculaRepository.getReferenceById(id));
        if (!entity.isPresent()) {
            throw new ParamNotFound("id invalido");
        }
        PeliculaDTO peliculaDTO = this.peliculaMapper.peliculaEntity2DTO(entity.get(), true);
        return peliculaDTO;


    }

    @Override
    public List<PeliculaDTO> getByFilters(String titulo, Long genero, String fechaCreacion, String order) {
        PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(titulo, genero, fechaCreacion, order);
        List<PeliculaEntity> entities = this.peliculaRepository.findAll(this.peliculaSpecif.getByFilters(filtersDTO));
        List<PeliculaDTO> dtos = this.peliculaMapper.peliculaEntitySet2DTOList(entities, true);
        return dtos;

    }

    @Override
    public PeliculaDTO update(Long id, PeliculaDTO pelicula) {
        return null;
    }

    @Override
    public PeliculaDTO save(PeliculaDTO pelicula) {
        return null;
    }

    @Override
    public void addPersonaje(Long id, Long idPersonaje) {

    }

    @Override
    public void removePersonaje(Long id, Long idPersonaje) {

    }

    @Override
    public void delete(Long id) {

    }
}
