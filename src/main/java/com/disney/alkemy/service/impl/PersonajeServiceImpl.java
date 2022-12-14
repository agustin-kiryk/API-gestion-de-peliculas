package com.disney.alkemy.service.impl;

import com.disney.alkemy.dto.PersonajeAuxDTO;
import com.disney.alkemy.dto.PersonajeDTO;
import com.disney.alkemy.dto.PersonajeFiltersDTO;
import com.disney.alkemy.entity.PersonajeEntity;
import com.disney.alkemy.repository.PeliculaRepository;
import com.disney.alkemy.repository.PersonajeRepository;
import com.disney.alkemy.repository.specif.PersonajeSpecif;
import com.disney.alkemy.service.PersonajeService;
import com.disney.alkemy.exceptions.ParamNotFound;
import com.disney.alkemy.mapper.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeSpecif personajeSpecif;
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitySaved, true);
        return result;
    }

    @Override
    public List<PersonajeDTO> getAllpersonajes() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntitySet2DTOList(entities, true);
        return result;
    }

    @Override
    public PersonajeDTO getDetailsById(Long id) {
        Optional<PersonajeEntity> entity = this.personajeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("id de personaje invalido");
        }
        PersonajeDTO personajeDTO = this.personajeMapper.personajeEntity2DTO(entity.get(), true);
        return personajeDTO;
    }

    @Override
    public PersonajeDTO update(Long id, PersonajeDTO personaje) {
        Optional<PersonajeEntity> entity = this.personajeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("id de personaje invalido");
        }
        this.personajeMapper.personajeEntityRefreshValues(entity.get(), personaje);
        PersonajeEntity updatedEntity = this.personajeRepository.save(entity.get());
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(updatedEntity, true);
        return result;
    }

    @Override
    public List<PersonajeAuxDTO> getByFilters(String nombre, Long edad, Set<Long> peliculas) {
        PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(nombre, edad, peliculas);
        List<PersonajeEntity> entities = this.personajeRepository.findAll(this.personajeSpecif.getByFilters(filtersDTO));
        List<PersonajeAuxDTO> dtos = this.personajeMapper.personajeEntitySet2AuxDTOList(entities);
        return dtos;
    }

    @Override
    public void delete(Long id) {
        PersonajeEntity entity = personajeRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("no se encuentra el id de personaje"));
        this.personajeRepository.deleteById(id);
    }
}
