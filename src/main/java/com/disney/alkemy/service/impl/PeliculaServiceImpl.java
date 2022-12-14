package com.disney.alkemy.service.impl;
import com.disney.alkemy.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.disney.alkemy.dto.PeliculaAuxDTO;
import com.disney.alkemy.dto.PeliculaDTO;
import com.disney.alkemy.dto.PeliculaFiltersDTO;
import com.disney.alkemy.entity.PeliculaEntity;
import com.disney.alkemy.entity.PersonajeEntity;
import com.disney.alkemy.repository.PeliculaRepository;
import com.disney.alkemy.repository.specif.PeliculaSpecif;
import com.disney.alkemy.service.PeliculaService;
import com.disney.alkemy.service.PersonajeService;
import com.disney.alkemy.exceptions.ParamNotFound;
import com.disney.alkemy.mapper.PeliculaMapper;


import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {


    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaSpecif peliculaSpecif;
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PersonajeService personajeService;
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PeliculaAuxDTO> getAll() {
        List<PeliculaEntity> entities = peliculaRepository.findAll();
        List<PeliculaAuxDTO> peliculaAuxDTO = peliculaMapper.peliculasEntityList2AuxDTOList(entities);
        return peliculaAuxDTO;
    }

    @Override
    public PeliculaDTO getDetailsById(Long id) {
        PeliculaEntity entity = peliculaRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de pelicula"));
        PeliculaDTO peliculaDTO = this.peliculaMapper.peliculaEntity2DTO(entity, true);
        return peliculaDTO;
    }

    @Override
    public List<PeliculaAuxDTO> getDetailsByFilters(String titulo, Long genero, String order) {
        PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(titulo, genero, order);
        List<PeliculaEntity> entities = this.peliculaRepository.findAll(this.peliculaSpecif.getByFilters(filtersDTO));
        List<PeliculaAuxDTO> dtos = this.peliculaMapper.peliculasEntityList2AuxDTOList(entities/*, true*/);
        return dtos;
    }

    @Override
    public PeliculaDTO update(Long id, PeliculaDTO pelicula) {
        Optional<PeliculaEntity> entity = this.peliculaRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("id de pelicula invalido");
        }
        this.peliculaMapper.peliculaEntityRefreshValues(entity.get(), pelicula);
        PeliculaEntity updatedEntity = this.peliculaRepository.save(entity.get());
        PeliculaDTO result = this.peliculaMapper.peliculaEntity2DTO(updatedEntity, true);
        return result;
    }

    @Override
    public PeliculaDTO save(PeliculaDTO pelicula) {

        PeliculaEntity entity = peliculaMapper.peliculaDTO2Entity(pelicula);
        PeliculaEntity entitySaved = peliculaRepository.save(entity);
        PeliculaDTO result = peliculaMapper.peliculaEntity2DTO(entitySaved, true);
        return result;
    }
    @Override
    public PeliculaDTO addPersonaje(Long id, Long idPersonaje) {

        PeliculaEntity entity = this.peliculaRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de pelicula"));
        PersonajeEntity personajeEntity = this.personajeRepository.findById(idPersonaje).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de personaje"));
        entity.addPersonaje(personajeEntity);
        PeliculaEntity entitysaved = this.peliculaRepository.save(entity);
        PeliculaDTO result = this.peliculaMapper.peliculaEntity2DTO(entitysaved, true);
        return result;
    }

    @Override
    public PeliculaDTO removePersonaje(Long id, Long idPersonaje) {

        PeliculaEntity entity = this.peliculaRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de pelicula"));
        PersonajeEntity personajeEntity = this.personajeRepository.findById(idPersonaje).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de personaje"));
        entity.removePersonaje(personajeEntity);
        PeliculaEntity entitysaved = this.peliculaRepository.save(entity);
        PeliculaDTO result = this.peliculaMapper.peliculaEntity2DTO(entitysaved, true);

        return result;
    }

    @Override
    public void delete(Long id) {
        PeliculaEntity entity = peliculaRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("ID de pelicula invalido :("));
        this.peliculaRepository.deleteById(id);

    }
}
