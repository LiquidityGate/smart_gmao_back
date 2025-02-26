package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_motivoDTO;
import com.gmao.gmao_backend.model.Alm_motivo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_motivoMapperImpl implements Alm_motivoMapper {

    @Override
    public Alm_motivoDTO toDto(Alm_motivo alm_motivo) {
        if ( alm_motivo == null ) {
            return null;
        }

        Alm_motivoDTO alm_motivoDTO = new Alm_motivoDTO();

        alm_motivoDTO.setId( alm_motivo.getId() );
        alm_motivoDTO.setNombre( alm_motivo.getNombre() );
        alm_motivoDTO.setEstado( alm_motivo.getEstado() );

        return alm_motivoDTO;
    }

    @Override
    public Alm_motivo toEntity(Alm_motivoDTO alm_motivoDTO) {
        if ( alm_motivoDTO == null ) {
            return null;
        }

        Alm_motivo alm_motivo = new Alm_motivo();

        alm_motivo.setId( alm_motivoDTO.getId() );
        alm_motivo.setNombre( alm_motivoDTO.getNombre() );
        alm_motivo.setEstado( alm_motivoDTO.getEstado() );

        return alm_motivo;
    }

    @Override
    public void updateFromDto(Alm_motivoDTO dto, Alm_motivo entity) {
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
