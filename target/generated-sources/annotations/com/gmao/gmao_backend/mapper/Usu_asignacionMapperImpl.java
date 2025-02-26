package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_asignacionDTO;
import com.gmao.gmao_backend.model.Usu_asignacion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_asignacionMapperImpl implements Usu_asignacionMapper {

    @Override
    public Usu_asignacionDTO toDto(Usu_asignacion usu_asignacion) {
        if ( usu_asignacion == null ) {
            return null;
        }

        Usu_asignacionDTO usu_asignacionDTO = new Usu_asignacionDTO();

        usu_asignacionDTO.setId( usu_asignacion.getId() );
        usu_asignacionDTO.setNombre( usu_asignacion.getNombre() );
        usu_asignacionDTO.setEstado( usu_asignacion.getEstado() );

        return usu_asignacionDTO;
    }

    @Override
    public Usu_asignacion toEntity(Usu_asignacionDTO usu_asignacionDTO) {
        if ( usu_asignacionDTO == null ) {
            return null;
        }

        Usu_asignacion usu_asignacion = new Usu_asignacion();

        usu_asignacion.setId( usu_asignacionDTO.getId() );
        usu_asignacion.setNombre( usu_asignacionDTO.getNombre() );
        usu_asignacion.setEstado( usu_asignacionDTO.getEstado() );

        return usu_asignacion;
    }

    @Override
    public void updateFromDto(Usu_asignacionDTO dto, Usu_asignacion entity) {
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
