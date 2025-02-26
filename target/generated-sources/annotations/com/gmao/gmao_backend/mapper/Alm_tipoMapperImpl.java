package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_tipoDTO;
import com.gmao.gmao_backend.model.Alm_tipo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_tipoMapperImpl implements Alm_tipoMapper {

    @Override
    public Alm_tipoDTO toDto(Alm_tipo alm_tipo) {
        if ( alm_tipo == null ) {
            return null;
        }

        Alm_tipoDTO alm_tipoDTO = new Alm_tipoDTO();

        alm_tipoDTO.setId( alm_tipo.getId() );
        alm_tipoDTO.setNombre( alm_tipo.getNombre() );
        alm_tipoDTO.setEstado( alm_tipo.getEstado() );

        return alm_tipoDTO;
    }

    @Override
    public Alm_tipo toEntity(Alm_tipoDTO alm_tipoDTO) {
        if ( alm_tipoDTO == null ) {
            return null;
        }

        Alm_tipo alm_tipo = new Alm_tipo();

        alm_tipo.setId( alm_tipoDTO.getId() );
        alm_tipo.setNombre( alm_tipoDTO.getNombre() );
        alm_tipo.setEstado( alm_tipoDTO.getEstado() );

        return alm_tipo;
    }

    @Override
    public void updateFromDto(Alm_tipoDTO dto, Alm_tipo entity) {
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
