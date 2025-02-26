package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesMenusAccesosDTO;
import com.gmao.gmao_backend.model.AccesoXPerfil;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MantenimientoPerfilesMapperImpl implements MantenimientoPerfilesMapper {

    @Override
    public MantenimientoPerfilesMenusAccesosDTO toDtoMenus(AccesoXPerfil usuario) {
        if ( usuario == null ) {
            return null;
        }

        MantenimientoPerfilesMenusAccesosDTO mantenimientoPerfilesMenusAccesosDTO = new MantenimientoPerfilesMenusAccesosDTO();

        mantenimientoPerfilesMenusAccesosDTO.setId( usuario.getId() );
        mantenimientoPerfilesMenusAccesosDTO.setIdPerfil( usuario.getIdPerfil() );
        mantenimientoPerfilesMenusAccesosDTO.setIdMenu( usuario.getIdMenu() );
        mantenimientoPerfilesMenusAccesosDTO.setEstado( usuario.getEstado() );
        mantenimientoPerfilesMenusAccesosDTO.setCreadoEn( usuario.getCreadoEn() );
        mantenimientoPerfilesMenusAccesosDTO.setActualizadoEn( usuario.getActualizadoEn() );
        mantenimientoPerfilesMenusAccesosDTO.setCrear( usuario.getCrear() );
        mantenimientoPerfilesMenusAccesosDTO.setVer( usuario.getVer() );
        mantenimientoPerfilesMenusAccesosDTO.setEditar( usuario.getEditar() );
        mantenimientoPerfilesMenusAccesosDTO.setEliminar( usuario.getEliminar() );

        return mantenimientoPerfilesMenusAccesosDTO;
    }

    @Override
    public AccesoXPerfil toEntityMenus(MantenimientoPerfilesMenusAccesosDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AccesoXPerfil accesoXPerfil = new AccesoXPerfil();

        accesoXPerfil.setCreadoPor( dto.getCreadoPorId() );
        accesoXPerfil.setActualizadoPor( dto.getActualizadoPorId() );
        accesoXPerfil.setId( dto.getId() );
        accesoXPerfil.setIdPerfil( dto.getIdPerfil() );
        accesoXPerfil.setIdMenu( dto.getIdMenu() );
        accesoXPerfil.setEstado( dto.getEstado() );
        accesoXPerfil.setCreadoEn( dto.getCreadoEn() );
        accesoXPerfil.setActualizadoEn( dto.getActualizadoEn() );
        accesoXPerfil.setCrear( dto.getCrear() );
        accesoXPerfil.setVer( dto.getVer() );
        accesoXPerfil.setEditar( dto.getEditar() );
        accesoXPerfil.setEliminar( dto.getEliminar() );

        return accesoXPerfil;
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

    @Override
    public void updateFromDtoAccesoXPerfil(MantenimientoPerfilesMenusAccesosDTO dto, AccesoXPerfil entity) {
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
        if ( dto.getIdPerfil() != null ) {
            entity.setIdPerfil( dto.getIdPerfil() );
        }
        if ( dto.getIdMenu() != null ) {
            entity.setIdMenu( dto.getIdMenu() );
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
        if ( dto.getCrear() != null ) {
            entity.setCrear( dto.getCrear() );
        }
        if ( dto.getVer() != null ) {
            entity.setVer( dto.getVer() );
        }
        if ( dto.getEditar() != null ) {
            entity.setEditar( dto.getEditar() );
        }
        if ( dto.getEliminar() != null ) {
            entity.setEliminar( dto.getEliminar() );
        }
    }

    @Override
    public MantenimientoPerfilesDTO toDtoUsuarioPerfil(UsuarioPerfil entity) {
        if ( entity == null ) {
            return null;
        }

        MantenimientoPerfilesDTO mantenimientoPerfilesDTO = new MantenimientoPerfilesDTO();

        mantenimientoPerfilesDTO.setCreadoPorId( entity.getCreadoPor() );
        mantenimientoPerfilesDTO.setActualizadoPorId( entity.getActualizadoPor() );
        mantenimientoPerfilesDTO.setId( entity.getId() );
        mantenimientoPerfilesDTO.setNombre( entity.getNombre() );
        mantenimientoPerfilesDTO.setDescripcion( entity.getDescripcion() );
        mantenimientoPerfilesDTO.setEstado( entity.getEstado() );
        mantenimientoPerfilesDTO.setCreadoEn( entity.getCreadoEn() );
        mantenimientoPerfilesDTO.setActualizadoEn( entity.getActualizadoEn() );
        mantenimientoPerfilesDTO.setEstadoEliminado( entity.getEstadoEliminado() );

        return mantenimientoPerfilesDTO;
    }

    @Override
    public UsuarioPerfil toEntityMantenimientoPerfilesDTO(MantenimientoPerfilesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();

        usuarioPerfil.setCreadoPor( dto.getCreadoPorId() );
        usuarioPerfil.setActualizadoPor( dto.getActualizadoPorId() );
        usuarioPerfil.setId( dto.getId() );
        usuarioPerfil.setNombre( dto.getNombre() );
        usuarioPerfil.setDescripcion( dto.getDescripcion() );
        usuarioPerfil.setActualizadoEn( dto.getActualizadoEn() );

        return usuarioPerfil;
    }

    @Override
    public void updateFromDtoMantenimientoPerfilesDTO(MantenimientoPerfilesDTO dto, UsuarioPerfil entity) {
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
