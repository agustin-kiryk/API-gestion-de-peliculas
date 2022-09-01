package com.disney.alkemy.Service.impl;

import com.disney.alkemy.DTO.PersonajeAuxDTO;
import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.DTO.PersonajeFiltersDTO;
import com.disney.alkemy.Entity.PersonajeEntity;
import com.disney.alkemy.Repository.PersonajeRepository;
import com.disney.alkemy.Repository.Specif.PersonajeSpecif;
import com.disney.alkemy.Service.PersonajeService;
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



    @Override
     public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitySaved, true);

        return result;
    }




    @Override
    public List<PersonajeAuxDTO> getAllpersonajes() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeAuxDTO> result = personajeMapper.personajeEntitySet2AuxDTOList(entities);
        return result;
    }

    @Override
    public PersonajeEntity getEntityById(Long idPersonaje) {
        return null;
    }

    /**  @Override
    public PersonajeEntity getEntityById(Long idPersonaje) {
        Optional<PersonajeEntity> entity = personajeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("id de personaje invalido");
        }
        PersonajeEntity result = entity.get();
        return result;

    }**/

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
    public List<PersonajeDTO> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculas) {
        PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(nombre, edad, peso, peliculas);
        List<PersonajeEntity> entities = this.personajeRepository.findAll(this.personajeSpecif.getByFilters(filtersDTO));
        List<PersonajeDTO> dtos = this.personajeMapper.personajeEntitySet2DTOList(entities, true);
        return dtos;
    }


    @Override
    public void delete(Long id) {
        this.personajeRepository.deleteById(id);
    }
}
