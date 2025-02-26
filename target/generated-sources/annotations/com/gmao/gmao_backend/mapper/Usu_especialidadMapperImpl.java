package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_especialidadDTO;
import com.gmao.gmao_backend.model.Usu_especialidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_especialidadMapperImpl implements Usu_especialidadMapper {

    @Override
    public Usu_especialidadDTO toDto(Usu_especialidad usu_especialidad) {
        if ( usu_especialidad == null ) {
            return null;
        }

        Usu_especialidadDTO usu_especialidadDTO = new Usu_especialidadDTO();

        usu_especialidadDTO.setId( usu_especialidad.getId() );
        usu_especialidadDTO.setNombre( usu_especialidad.getNombre() );
        usu_especialidadDTO.setEstado( usu_especialidad.getEstado() );

        return usu_especialidadDTO;
    }

    @Override
    public Usu_especialidad toEntity(Usu_especialidadDTO usu_especialidadDTO) {
        if ( usu_especialidadDTO == null ) {
            return null;
        }

        Usu_especialidad usu_especialidad = new Usu_especialidad();

        usu_especialidad.setId( usu_especialidadDTO.getId() );
        usu_especialidad.setNombre( usu_especialidadDTO.getNombre() );
        usu_especialidad.setEstado( usu_especialidadDTO.getEstado() );

        return usu_especialidad;
    }

    @Override
    public void updateFromDto(Usu_especialidadDTO dto, Usu_especialidad entity) {
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
