package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_usuarioDTO;
import com.gmao.gmao_backend.model.Usu_usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_usuarioMapperImpl implements Usu_usuarioMapper {

    @Override
    public Usu_usuarioDTO toDto(Usu_usuario usu_usuario) {
        if ( usu_usuario == null ) {
            return null;
        }

        Usu_usuarioDTO usu_usuarioDTO = new Usu_usuarioDTO();

        usu_usuarioDTO.setId( usu_usuario.getId() );
        usu_usuarioDTO.setUsuario( usu_usuario.getUsuario() );
        usu_usuarioDTO.setNombre( usu_usuario.getNombre() );
        usu_usuarioDTO.setEmail( usu_usuario.getEmail() );
        usu_usuarioDTO.setTelefono( usu_usuario.getTelefono() );
        usu_usuarioDTO.setTipo_documento( usu_usuario.getTipo_documento() );
        usu_usuarioDTO.setNro_documento( usu_usuario.getNro_documento() );
        usu_usuarioDTO.setCargo( usu_usuario.getCargo() );
        usu_usuarioDTO.setPerfil( usu_usuario.getPerfil() );
        usu_usuarioDTO.setSubtipo( usu_usuario.getSubtipo() );
        usu_usuarioDTO.setEmpresa( usu_usuario.getEmpresa() );
        usu_usuarioDTO.setTurno( usu_usuario.getTurno() );
        usu_usuarioDTO.setTrabajando( usu_usuario.getTrabajando() );
        usu_usuarioDTO.setEstado( usu_usuario.getEstado() );

        return usu_usuarioDTO;
    }

    @Override
    public Usu_usuario toEntity(Usu_usuarioDTO usu_usuarioDTO) {
        if ( usu_usuarioDTO == null ) {
            return null;
        }

        Usu_usuario usu_usuario = new Usu_usuario();

        usu_usuario.setId( usu_usuarioDTO.getId() );
        usu_usuario.setUsuario( usu_usuarioDTO.getUsuario() );
        usu_usuario.setNombre( usu_usuarioDTO.getNombre() );
        usu_usuario.setEmail( usu_usuarioDTO.getEmail() );
        usu_usuario.setTelefono( usu_usuarioDTO.getTelefono() );
        usu_usuario.setTipo_documento( usu_usuarioDTO.getTipo_documento() );
        usu_usuario.setNro_documento( usu_usuarioDTO.getNro_documento() );
        usu_usuario.setCargo( usu_usuarioDTO.getCargo() );
        usu_usuario.setPerfil( usu_usuarioDTO.getPerfil() );
        usu_usuario.setSubtipo( usu_usuarioDTO.getSubtipo() );
        usu_usuario.setEmpresa( usu_usuarioDTO.getEmpresa() );
        usu_usuario.setTurno( usu_usuarioDTO.getTurno() );
        usu_usuario.setTrabajando( usu_usuarioDTO.getTrabajando() );
        usu_usuario.setEstado( usu_usuarioDTO.getEstado() );

        return usu_usuario;
    }

    @Override
    public void updateFromDto(Usu_usuarioDTO dto, Usu_usuario entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUsuario() != null ) {
            entity.setUsuario( dto.getUsuario() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getTelefono() != null ) {
            entity.setTelefono( dto.getTelefono() );
        }
        if ( dto.getTipo_documento() != null ) {
            entity.setTipo_documento( dto.getTipo_documento() );
        }
        if ( dto.getNro_documento() != null ) {
            entity.setNro_documento( dto.getNro_documento() );
        }
        if ( dto.getCargo() != null ) {
            entity.setCargo( dto.getCargo() );
        }
        if ( dto.getPerfil() != null ) {
            entity.setPerfil( dto.getPerfil() );
        }
        if ( dto.getSubtipo() != null ) {
            entity.setSubtipo( dto.getSubtipo() );
        }
        if ( dto.getEmpresa() != null ) {
            entity.setEmpresa( dto.getEmpresa() );
        }
        if ( dto.getTurno() != null ) {
            entity.setTurno( dto.getTurno() );
        }
        if ( dto.getTrabajando() != null ) {
            entity.setTrabajando( dto.getTrabajando() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
