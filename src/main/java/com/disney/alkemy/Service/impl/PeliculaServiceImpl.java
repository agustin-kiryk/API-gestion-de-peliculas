package com.disney.alkemy.Service.impl;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Repository.PersonajeRepository;
import com.disney.alkemy.mapper.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
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

 //   private PersonajeMapper personajeMapper;

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
          PersonajeRepository personajeRepository
          //  PersonajeMapper personajeMapper
    ) {
        this.peliculaRepository = peliculaRepository;
        this.peliculaSpecif = peliculaSpecif;
        this.peliculaMapper = peliculaMapper;
        this.personajeService = personajeService;
        this.personajeRepository = personajeRepository;
       // this.personajeMapper = personajeMapper;
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

        PeliculaDTO peliculaDTO = this.peliculaMapper.peliculaEntity2DTO(entity.get(), true);
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
       // List<PersonajeDTO>personajes=personajeMapper.personajeEntitySet2DTOList(entitySaved.getPersonajes(),true);
        PeliculaDTO result = peliculaMapper.peliculaEntity2DTO(entitySaved, true);
        return result;
    }

    @Override
    public void addPersonaje(Long id, Long idPersonaje) {

        PeliculaEntity entity = this.peliculaRepository.findById(id).orElseThrow(
                ()->new ParamNotFound("no se encuentra el id de pelicula"));
        PersonajeEntity personajeEntity = this.personajeRepository.findById(idPersonaje).orElseThrow(
                ()->new ParamNotFound("no se encuentra el id de personaje"));
        entity.addPersonaje(personajeEntity);
      this.peliculaRepository.save(entity);

    }


    @Override
    public PeliculaDTO removePersonaje(Long id, Long idPersonaje) {
        PeliculaEntity entity = this.peliculaRepository.findById(id).orElseThrow(
                ()->new ParamNotFound("no se encuentra el id de pelicula"));

        PersonajeEntity personajeEntity = this.personajeRepository.findById(idPersonaje).orElseThrow(
                ()-> new ParamNotFound("no se encuentra el id de personaje"));
        entity.getPersonajes().remove(personajeEntity);
        PeliculaEntity entitysaved = this.peliculaRepository.save(entity);
        PeliculaDTO result= this.peliculaMapper.peliculaEntity2DTO(entitysaved, true);
        return result;


    }
   /* public PeliculaDTO removePersonaje(Long id, Long idPersonaje) {
        PeliculaEntity entity = this.peliculaRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de pelicula"));


        PersonajeEntity personajeEntity = this.personajeRepository.findById(idPersonaje).orElseThrow(
                () -> new ParamNotFound("El personaje no se encuentra en esta pelicula"));

        PersonajeEntity personaje = new PersonajeEntity();

        personaje.setPeliculas(personajeEntity.getPeliculas());
        personaje.setImagen(personajeEntity.getImagen());
        personaje.setNombre(personajeEntity.getNombre());
        personaje.setEdad(personajeEntity.getEdad());
        personaje.setId(personajeEntity.getId());
        personaje.setPeso(personajeEntity.getPeso());
        personaje.setHistoria(personajeEntity.getHistoria());
        personaje.setDeleted(Boolean.FALSE);
        int valorHashEntity = personajeEntity.hashCode();
        int valorHashEntityNueva = personaje .hashCode();
        entity.getPersonajes().remove(personaje);
        PeliculaEntity entitysaved = this.peliculaRepository.save(entity);
        PeliculaDTO result = this.peliculaMapper.peliculaEntity2DTO(entitysaved, true);
        return result;
    }*/





    @Override
    public void delete(Long id) {
        Optional<PeliculaEntity> entity = peliculaRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("id de pelicula no encontrado");
        }
        this.peliculaRepository.deleteById(id);

    }
}
