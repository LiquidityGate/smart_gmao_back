package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_empresaDTO;
import com.gmao.gmao_backend.model.Alm_empresa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_empresaMapperImpl implements Alm_empresaMapper {

    @Override
    public Alm_empresaDTO toDto(Alm_empresa alm_empresa) {
        if ( alm_empresa == null ) {
            return null;
        }

        Alm_empresaDTO alm_empresaDTO = new Alm_empresaDTO();

        alm_empresaDTO.setId( alm_empresa.getId() );
        alm_empresaDTO.setNombre( alm_empresa.getNombre() );
        alm_empresaDTO.setEstado( alm_empresa.getEstado() );

        return alm_empresaDTO;
    }

    @Override
    public Alm_empresa toEntity(Alm_empresaDTO alm_empresaDTO) {
        if ( alm_empresaDTO == null ) {
            return null;
        }

        Alm_empresa alm_empresa = new Alm_empresa();

        alm_empresa.setId( alm_empresaDTO.getId() );
        alm_empresa.setNombre( alm_empresaDTO.getNombre() );
        alm_empresa.setEstado( alm_empresaDTO.getEstado() );

        return alm_empresa;
    }

    @Override
    public void updateFromDto(Alm_empresaDTO dto, Alm_empresa entity) {
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
