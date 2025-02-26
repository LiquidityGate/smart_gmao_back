package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_mantenimientoDTO;
import com.gmao.gmao_backend.model.Alm_mantenimiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_mantenimientoMapperImpl implements Alm_mantenimientoMapper {

    @Override
    public Alm_mantenimientoDTO toDto(Alm_mantenimiento alm_mantenimiento) {
        if ( alm_mantenimiento == null ) {
            return null;
        }

        Alm_mantenimientoDTO alm_mantenimientoDTO = new Alm_mantenimientoDTO();

        alm_mantenimientoDTO.setId( alm_mantenimiento.getId() );
        alm_mantenimientoDTO.setNombre( alm_mantenimiento.getNombre() );
        alm_mantenimientoDTO.setEstado( alm_mantenimiento.getEstado() );

        return alm_mantenimientoDTO;
    }

    @Override
    public Alm_mantenimiento toEntity(Alm_mantenimientoDTO alm_mantenimientoDTO) {
        if ( alm_mantenimientoDTO == null ) {
            return null;
        }

        Alm_mantenimiento alm_mantenimiento = new Alm_mantenimiento();

        alm_mantenimiento.setId( alm_mantenimientoDTO.getId() );
        alm_mantenimiento.setNombre( alm_mantenimientoDTO.getNombre() );
        alm_mantenimiento.setEstado( alm_mantenimientoDTO.getEstado() );

        return alm_mantenimiento;
    }

    @Override
    public void updateFromDto(Alm_mantenimientoDTO dto, Alm_mantenimiento entity) {
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
