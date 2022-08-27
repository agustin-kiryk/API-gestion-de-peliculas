package com.disney.disney.Service.impl;

import com.disney.disney.DTO.GeneroDTO;
import com.disney.disney.Entity.GeneroEntity;
import com.disney.disney.Repository.GeneroRepository;
import com.disney.disney.Service.GeneroService;
import com.disney.disney.mapper.GeneroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {
@Autowired
private GeneroMapper generoMapper;
@Autowired
 private    GeneroRepository generoRepository;


    public GeneroDTO save(GeneroDTO dto){
        GeneroEntity entity = generoMapper.generodto2Entity(dto); //convierto a entity
        GeneroEntity entitySaved = generoRepository.save(entity);    //guardardo
        GeneroDTO result = generoMapper.generoEntity2DTO(entitySaved);//convierto a DTO

        return result; //devuelvo DTO

    }



    @Override
    public List<GeneroDTO> getAllgeneros() {
        List<GeneroEntity> entities = generoRepository.findAll();
        List<GeneroDTO> result = generoMapper.generoEntityList2DTOList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        this.generoRepository.deleteById(id);
    }


}
