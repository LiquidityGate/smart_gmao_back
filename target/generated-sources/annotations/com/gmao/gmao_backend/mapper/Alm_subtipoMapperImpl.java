package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_subtipoDTO;
import com.gmao.gmao_backend.model.Alm_subtipo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_subtipoMapperImpl implements Alm_subtipoMapper {

    @Override
    public Alm_subtipoDTO toDto(Alm_subtipo alm_subtipo) {
        if ( alm_subtipo == null ) {
            return null;
        }

        Alm_subtipoDTO alm_subtipoDTO = new Alm_subtipoDTO();

        alm_subtipoDTO.setId( alm_subtipo.getId() );
        alm_subtipoDTO.setNombre( alm_subtipo.getNombre() );
        alm_subtipoDTO.setEstado( alm_subtipo.getEstado() );

        return alm_subtipoDTO;
    }

    @Override
    public Alm_subtipo toEntity(Alm_subtipoDTO alm_subtipoDTO) {
        if ( alm_subtipoDTO == null ) {
            return null;
        }

        Alm_subtipo alm_subtipo = new Alm_subtipo();

        alm_subtipo.setId( alm_subtipoDTO.getId() );
        alm_subtipo.setNombre( alm_subtipoDTO.getNombre() );
        alm_subtipo.setEstado( alm_subtipoDTO.getEstado() );

        return alm_subtipo;
    }

    @Override
    public void updateFromDto(Alm_subtipoDTO dto, Alm_subtipo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
