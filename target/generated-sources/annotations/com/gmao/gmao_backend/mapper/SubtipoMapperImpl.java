package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SubtipoDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.Subtipo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SubtipoMapperImpl implements SubtipoMapper {

    @Override
    public SubtipoDTO toDto(Subtipo subtipo) {
        if ( subtipo == null ) {
            return null;
        }

        SubtipoDTO subtipoDTO = new SubtipoDTO();

        subtipoDTO.setIngresado_porId( subtipoIngresado_porId( subtipo ) );
        subtipoDTO.setId( subtipo.getId() );
        subtipoDTO.setNombre_tipo( subtipo.getNombre_tipo() );
        subtipoDTO.setNombre_subtipo( subtipo.getNombre_subtipo() );
        subtipoDTO.setEstado( subtipo.getEstado() );
        subtipoDTO.setFecha( subtipo.getFecha() );

        subtipoDTO.setIngresado_porNombre( subtipo.getIngresado_por().getNombres() + ' ' + subtipo.getIngresado_por().getApellidos() );

        return subtipoDTO;
    }

    @Override
    public Subtipo toEntity(SubtipoDTO subtipoDTO) {
        if ( subtipoDTO == null ) {
            return null;
        }

        Subtipo subtipo = new Subtipo();

        subtipo.setId( subtipoDTO.getId() );
        subtipo.setNombre_tipo( subtipoDTO.getNombre_tipo() );
        subtipo.setEstado( subtipoDTO.getEstado() );
        subtipo.setFecha( subtipoDTO.getFecha() );

        return subtipo;
    }

    @Override
    public void updateFromDto(SubtipoDTO dto, Subtipo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre_tipo() != null ) {
            entity.setNombre_tipo( dto.getNombre_tipo() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getFecha() != null ) {
            entity.setFecha( dto.getFecha() );
        }
    }

    private Long subtipoIngresado_porId(Subtipo subtipo) {
        if ( subtipo == null ) {
            return null;
        }
        AdministracionUsuarios ingresado_por = subtipo.getIngresado_por();
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
