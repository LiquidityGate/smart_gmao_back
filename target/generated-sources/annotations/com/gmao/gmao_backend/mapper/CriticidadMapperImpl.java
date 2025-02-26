package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.CriticidadDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.Criticidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CriticidadMapperImpl implements CriticidadMapper {

    @Override
    public CriticidadDTO toDto(Criticidad criticidad) {
        if ( criticidad == null ) {
            return null;
        }

        CriticidadDTO criticidadDTO = new CriticidadDTO();

        criticidadDTO.setIngresado_porId( criticidadIngresado_porId( criticidad ) );
        criticidadDTO.setId( criticidad.getId() );
        criticidadDTO.setNombre( criticidad.getNombre() );
        criticidadDTO.setEstado( criticidad.getEstado() );
        criticidadDTO.setFecha( criticidad.getFecha() );

        criticidadDTO.setIngresado_porNombre( criticidad.getIngresado_por().getNombres() + ' ' + criticidad.getIngresado_por().getApellidos() );

        return criticidadDTO;
    }

    @Override
    public Criticidad toEntity(CriticidadDTO criticidadDTO) {
        if ( criticidadDTO == null ) {
            return null;
        }

        Criticidad criticidad = new Criticidad();

        criticidad.setId( criticidadDTO.getId() );
        criticidad.setNombre( criticidadDTO.getNombre() );
        criticidad.setEstado( criticidadDTO.getEstado() );
        criticidad.setFecha( criticidadDTO.getFecha() );

        return criticidad;
    }

    @Override
    public void updateFromDto(CriticidadDTO dto, Criticidad entity) {
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
        if ( dto.getFecha() != null ) {
            entity.setFecha( dto.getFecha() );
        }
    }

    private Long criticidadIngresado_porId(Criticidad criticidad) {
        if ( criticidad == null ) {
            return null;
        }
        AdministracionUsuarios ingresado_por = criticidad.getIngresado_por();
        if ( ingresado_por == null ) {
            return null;
        }
        Long id = ingresado_por.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
