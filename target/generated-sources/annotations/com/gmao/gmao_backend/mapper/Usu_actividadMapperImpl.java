package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_actividadDTO;
import com.gmao.gmao_backend.model.Usu_actividad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_actividadMapperImpl implements Usu_actividadMapper {

    @Override
    public Usu_actividadDTO toDto(Usu_actividad usu_actividad) {
        if ( usu_actividad == null ) {
            return null;
        }

        Usu_actividadDTO usu_actividadDTO = new Usu_actividadDTO();

        usu_actividadDTO.setId( usu_actividad.getId() );
        usu_actividadDTO.setNombre( usu_actividad.getNombre() );
        usu_actividadDTO.setEstado( usu_actividad.getEstado() );

        return usu_actividadDTO;
    }

    @Override
    public Usu_actividad toEntity(Usu_actividadDTO usu_actividadDTO) {
        if ( usu_actividadDTO == null ) {
            return null;
        }

        Usu_actividad usu_actividad = new Usu_actividad();

        usu_actividad.setId( usu_actividadDTO.getId() );
        usu_actividad.setNombre( usu_actividadDTO.getNombre() );
        usu_actividad.setEstado( usu_actividadDTO.getEstado() );

        return usu_actividad;
    }

    @Override
    public void updateFromDto(Usu_actividadDTO dto, Usu_actividad entity) {
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
