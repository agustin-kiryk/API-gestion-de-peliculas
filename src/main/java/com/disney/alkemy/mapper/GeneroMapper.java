package com.disney.alkemy.mapper;

import com.disney.alkemy.DTO.GeneroDTO;
import com.disney.alkemy.Entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {
     public GeneroEntity generodto2Entity (GeneroDTO dto){
         GeneroEntity generoEntity = new GeneroEntity();
         generoEntity.setNombre(dto.getNombre());
         generoEntity.setImagen(dto.getImagen());
         return generoEntity;
     }
    public GeneroDTO generoEntity2DTO(GeneroEntity entity){
         GeneroDTO dto = new GeneroDTO();
         dto.setId(entity.getId());
         dto.setNombre(entity.getNombre());
         dto.setImagen(entity.getImagen());
         return dto;
    }

    public List<GeneroDTO> generoEntityList2DTOList (List<GeneroEntity> entities){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (GeneroEntity entity : entities) {
            dtos.add(this.generoEntity2DTO(entity));
        }
        return dtos;
    }

}
