package com.disney.alkemy.Service.impl;

import com.disney.alkemy.DTO.PersonajeDTO;
import com.disney.alkemy.Entity.PersonajeEntity;
import com.disney.alkemy.Repository.PersonajeRepository;
import com.disney.alkemy.Service.PersonajeService;
import com.disney.alkemy.mapper.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.personajedto2Entity(dto);
        PersonajeEntity entitysaved = personajeRepository.save(entity);
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitysaved);

        return result;
    }

    @Override
    public List<PersonajeDTO> getAllpersonajes() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntityList2DTOList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        this.personajeRepository.deleteById(id);
    }
}
