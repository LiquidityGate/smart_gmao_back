package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UsuarioPerfilMapperImpl implements UsuarioPerfilMapper {

    @Override
    public MantenimientoPerfilesDTO toDto(UsuarioPerfil usrPerfil) {
        if ( usrPerfil == null ) {
            return null;
        }

        MantenimientoPerfilesDTO mantenimientoPerfilesDTO = new MantenimientoPerfilesDTO();

        mantenimientoPerfilesDTO.setCreadoPorId( usrPerfil.getCreadoPor() );
        mantenimientoPerfilesDTO.setActualizadoPorId( usrPerfil.getActualizadoPor() );
        mantenimientoPerfilesDTO.setId( usrPerfil.getId() );
        mantenimientoPerfilesDTO.setNombre( usrPerfil.getNombre() );
        mantenimientoPerfilesDTO.setDescripcion( usrPerfil.getDescripcion() );
        mantenimientoPerfilesDTO.setEstado( usrPerfil.getEstado() );
        mantenimientoPerfilesDTO.setCreadoEn( usrPerfil.getCreadoEn() );
        mantenimientoPerfilesDTO.setActualizadoEn( usrPerfil.getActualizadoEn() );
        mantenimientoPerfilesDTO.setEstadoEliminado( usrPerfil.getEstadoEliminado() );

        mantenimientoPerfilesDTO.setCreadoPorNombre( "" );
        mantenimientoPerfilesDTO.setActualizadoPorNombre( "" );

        return mantenimientoPerfilesDTO;
    }

    @Override
    public UsuarioPerfil toEntity(MantenimientoPerfilesDTO usrPerfilDTO) {
        if ( usrPerfilDTO == null ) {
            return null;
        }

        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();

        usuarioPerfil.setCreadoPor( usrPerfilDTO.getCreadoPorId() );
        usuarioPerfil.setActualizadoPor( usrPerfilDTO.getActualizadoPorId() );
        usuarioPerfil.setId( usrPerfilDTO.getId() );
        usuarioPerfil.setNombre( usrPerfilDTO.getNombre() );
        usuarioPerfil.setDescripcion( usrPerfilDTO.getDescripcion() );
        usuarioPerfil.setEstado( usrPerfilDTO.getEstado() );
        usuarioPerfil.setCreadoEn( usrPerfilDTO.getCreadoEn() );
        usuarioPerfil.setActualizadoEn( usrPerfilDTO.getActualizadoEn() );
        usuarioPerfil.setEstadoEliminado( usrPerfilDTO.getEstadoEliminado() );

        return usuarioPerfil;
    }

    @Override
    public void updateFromDto(MantenimientoPerfilesDTO dto, UsuarioPerfil entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCreadoPorId() != null ) {
            entity.setCreadoPor( dto.getCreadoPorId() );
        }
        if ( dto.getActualizadoPorId() != null ) {
            entity.setActualizadoPor( dto.getActualizadoPorId() );
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
        if ( dto.getActualizadoEn() != null ) {
            entity.setActualizadoEn( dto.getActualizadoEn() );
        }
        if ( dto.getEstadoEliminado() != null ) {
            entity.setEstadoEliminado( dto.getEstadoEliminado() );
        }
    }
}
