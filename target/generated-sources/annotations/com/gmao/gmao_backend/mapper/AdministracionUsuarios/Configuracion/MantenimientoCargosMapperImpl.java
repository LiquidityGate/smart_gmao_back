package com.gmao.gmao_backend.mapper.AdministracionUsuarios.Configuracion;

import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosTablaDTO;
import com.gmao.gmao_backend.model.UsuarioCargo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MantenimientoCargosMapperImpl implements MantenimientoCargosMapper {

    @Override
    public MantenimientoCargosTablaDTO toDtoTabla(UsuarioCargo usuario) {
        if ( usuario == null ) {
            return null;
        }

        MantenimientoCargosTablaDTO mantenimientoCargosTablaDTO = new MantenimientoCargosTablaDTO();

        mantenimientoCargosTablaDTO.setId( usuario.getId() );
        mantenimientoCargosTablaDTO.setNombre( usuario.getNombre() );
        mantenimientoCargosTablaDTO.setDescripcion( usuario.getDescripcion() );
        mantenimientoCargosTablaDTO.setEstado( usuario.getEstado() );
        mantenimientoCargosTablaDTO.setCreadoEn( usuario.getCreadoEn() );
        if ( usuario.getCreadoPor() != null ) {
            mantenimientoCargosTablaDTO.setCreadoPor( String.valueOf( usuario.getCreadoPor() ) );
        }

        return mantenimientoCargosTablaDTO;
    }

    @Override
    public UsuarioCargo toEntityTabla(MantenimientoCargosTablaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioCargo usuarioCargo = new UsuarioCargo();

        usuarioCargo.setId( dto.getId() );
        usuarioCargo.setNombre( dto.getNombre() );
        usuarioCargo.setDescripcion( dto.getDescripcion() );
        usuarioCargo.setEstado( dto.getEstado() );
        usuarioCargo.setCreadoEn( dto.getCreadoEn() );
        if ( dto.getCreadoPor() != null ) {
            usuarioCargo.setCreadoPor( Long.parseLong( dto.getCreadoPor() ) );
        }

        return usuarioCargo;
    }

    @Override
    public void updateFromDto(MantenimientoCargosTablaDTO dto, UsuarioCargo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getCreadoEn() != null ) {
            entity.setCreadoEn( dto.getCreadoEn() );
        }
        if ( dto.getCreadoPor() != null ) {
            entity.setCreadoPor( Long.parseLong( dto.getCreadoPor() ) );
        }
    }
}
