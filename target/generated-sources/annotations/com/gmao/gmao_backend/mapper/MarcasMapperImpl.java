package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.MarcasDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.Marcas;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MarcasMapperImpl implements MarcasMapper {

    @Override
    public MarcasDTO toDto(Marcas marcas) {
        if ( marcas == null ) {
            return null;
        }

        MarcasDTO marcasDTO = new MarcasDTO();

        marcasDTO.setIngresado_porId( marcasIngresado_porId( marcas ) );
        marcasDTO.setId( marcas.getId() );
        marcasDTO.setNombre( marcas.getNombre() );
        marcasDTO.setEstado( marcas.getEstado() );
        marcasDTO.setFecha( marcas.getFecha() );

        marcasDTO.setIngresado_porNombre( marcas.getIngresado_por().getNombres() + ' ' + marcas.getIngresado_por().getApellidos() );

        return marcasDTO;
    }

    @Override
    public Marcas toEntity(MarcasDTO marcasDTO) {
        if ( marcasDTO == null ) {
            return null;
        }

        Marcas marcas = new Marcas();

        marcas.setId( marcasDTO.getId() );
        marcas.setNombre( marcasDTO.getNombre() );
        marcas.setEstado( marcasDTO.getEstado() );
        marcas.setFecha( marcasDTO.getFecha() );

        return marcas;
    }

    @Override
    public void updateFromDto(MarcasDTO dto, Marcas entity) {
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

    private Long marcasIngresado_porId(Marcas marcas) {
        if ( marcas == null ) {
            return null;
        }
        AdministracionUsuarios ingresado_por = marcas.getIngresado_por();
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
