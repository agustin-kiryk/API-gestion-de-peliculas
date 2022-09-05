package com.disney.alkemy.Service.impl;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Repository.PersonajeRepository;
import com.disney.alkemy.mapper.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.disney.alkemy.DTO.PeliculaAuxDTO;
import com.disney.alkemy.DTO.PeliculaDTO;
import com.disney.alkemy.DTO.PeliculaFiltersDTO;
import com.disney.alkemy.Entity.PeliculaEntity;
import com.disney.alkemy.Entity.PersonajeEntity;
import com.disney.alkemy.Repository.PeliculaRepository;
import com.disney.alkemy.Repository.Specif.PeliculaSpecif;
import com.disney.alkemy.Service.PeliculaService;
import com.disney.alkemy.Service.PersonajeService;
import com.disney.alkemy.exceptions.ParamNotFound;
import com.disney.alkemy.mapper.PeliculaMapper;


import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private PersonajeMapper personajeMapper;

    private PeliculaRepository peliculaRepository;

    private PeliculaSpecif peliculaSpecif;

    private PeliculaMapper peliculaMapper;

    private PersonajeService personajeService;

    private PersonajeRepository personajeRepository;


    @Autowired
    public PeliculaServiceImpl(
            PeliculaRepository peliculaRepository,
            PeliculaSpecif peliculaSpecif,
            PeliculaMapper peliculaMapper,
            PersonajeService personajeService,
            PersonajeMapper personajeMapper
    ) {
        this.peliculaRepository = peliculaRepository;
        this.peliculaSpecif = peliculaSpecif;
        this.peliculaMapper = peliculaMapper;
        this.personajeService = personajeService;
        this.personajeMapper = personajeMapper;
    }
    @Override
    public List<PeliculaAuxDTO> getAll() {
        List<PeliculaEntity> entities = peliculaRepository.findAll();
        List<PeliculaAuxDTO> peliculaAuxDTO = peliculaMapper.peliculasEntityList2AuxDTOList(entities);
        return peliculaAuxDTO;

    }

    @Override
    public PeliculaDTO getDetailsById(Long id) {
        Optional<PeliculaEntity> entity = peliculaRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("id de pelicula invalido");
        }
        PeliculaDTO peliculaDTO = this.peliculaMapper.peliculaEntity2DTO(entity.get(), true);
        return peliculaDTO;


    }




    @Override
    public List<PeliculaDTO> getDetailsByFilters(String titulo, Long genero, String order) {
        PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(titulo, genero, order);
        List<PeliculaEntity> entities = this.peliculaRepository.findAll(this.peliculaSpecif.getByFilters(filtersDTO));
        List<PeliculaDTO> dtos = this.peliculaMapper.peliculaEntitySet2DTOList(entities, true);
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
        List<PersonajeDTO>personajes=personajeMapper.personajeEntitySet2DTOList(entitySaved.getPersonajes(),true);
        PeliculaDTO result = peliculaMapper.peliculaEntity2DTO(entitySaved, true);
        return result;
    }

    @Override
    public void addPersonaje(Long id, Long idPersonaje) {
        Optional<PeliculaEntity> pelicula= this.peliculaRepository.findById(id);
        Optional<PersonajeEntity> personaje= this.personajeRepository.findById(idPersonaje);
        if (!pelicula.isPresent() && !personaje.isPresent())
            throw new ParamNotFound("id invalido");
        else
        if(!pelicula.isPresent())
            throw new ParamNotFound("ID pelicula invalido");
        else
        if(!personaje.isPresent())
            throw new ParamNotFound("ID personaje invalido");
        if (!pelicula.get().getPersonajes().contains(personaje.get()))
        {
            pelicula.get().getPersonajes().add(personaje.get());
            peliculaRepository.save(pelicula.get());
        }
        personaje.get().getPeliculas().add(pelicula.get());
        personajeRepository.save(personaje.get());

    }


    @Override
    public void removePersonaje(Long id, Long idPersonaje) {
        PeliculaEntity entity = this.peliculaRepository.getReferenceById(id);
        entity.getPersonajes().size();
        PersonajeEntity personajeEntity = this.personajeService.getEntityById(idPersonaje);
        entity.removePersonaje(personajeEntity);
        this.peliculaRepository.save(entity);

    }

    @Override
    public void delete(Long id) {
        this.peliculaRepository.deleteById(id);

    }
}
