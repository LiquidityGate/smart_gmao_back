package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.TipoDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.Tipo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class TipoMapperImpl implements TipoMapper {

    @Override
    public TipoDTO toDto(Tipo tipo) {
        if ( tipo == null ) {
            return null;
        }

        TipoDTO tipoDTO = new TipoDTO();

        tipoDTO.setIngresado_porId( tipoIngresado_porId( tipo ) );
        tipoDTO.setId( tipo.getId() );
        tipoDTO.setNombre( tipo.getNombre() );
        tipoDTO.setEstado( tipo.getEstado() );
        tipoDTO.setFecha( tipo.getFecha() );

        tipoDTO.setIngresado_porNombre( tipo.getIngresado_por().getNombres() + ' ' + tipo.getIngresado_por().getApellidos() );

        return tipoDTO;
    }

    @Override
    public Tipo toEntity(TipoDTO tipoDTO) {
        if ( tipoDTO == null ) {
            return null;
        }

        Tipo tipo = new Tipo();

        tipo.setId( tipoDTO.getId() );
        tipo.setNombre( tipoDTO.getNombre() );
        tipo.setEstado( tipoDTO.getEstado() );
        tipo.setFecha( tipoDTO.getFecha() );

        return tipo;
    }

    @Override
    public void updateFromDto(TipoDTO dto, Tipo entity) {
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

    private Long tipoIngresado_porId(Tipo tipo) {
        if ( tipo == null ) {
            return null;
        }
        AdministracionUsuarios ingresado_por = tipo.getIngresado_por();
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
