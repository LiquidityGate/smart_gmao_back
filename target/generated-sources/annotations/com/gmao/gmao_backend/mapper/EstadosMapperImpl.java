package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.EstadosDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.Estados;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class EstadosMapperImpl implements EstadosMapper {

    @Override
    public EstadosDTO toDto(Estados estados) {
        if ( estados == null ) {
            return null;
        }

        EstadosDTO estadosDTO = new EstadosDTO();

        estadosDTO.setIngresado_porId( estadosIngresado_porId( estados ) );
        estadosDTO.setId( estados.getId() );
        estadosDTO.setNombre( estados.getNombre() );
        estadosDTO.setEstado( estados.getEstado() );
        estadosDTO.setFecha( estados.getFecha() );

        estadosDTO.setIngresado_porNombre( estados.getIngresado_por().getNombres() + ' ' + estados.getIngresado_por().getApellidos() );

        return estadosDTO;
    }

    @Override
    public Estados toEntity(EstadosDTO estadosDTO) {
        if ( estadosDTO == null ) {
            return null;
        }

        Estados estados = new Estados();

        estados.setId( estadosDTO.getId() );
        estados.setNombre( estadosDTO.getNombre() );
        estados.setEstado( estadosDTO.getEstado() );
        estados.setFecha( estadosDTO.getFecha() );

        return estados;
    }

    @Override
    public void updateFromDto(EstadosDTO dto, Estados entity) {
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

    private Long estadosIngresado_porId(Estados estados) {
        if ( estados == null ) {
            return null;
        }
        AdministracionUsuarios ingresado_por = estados.getIngresado_por();
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
