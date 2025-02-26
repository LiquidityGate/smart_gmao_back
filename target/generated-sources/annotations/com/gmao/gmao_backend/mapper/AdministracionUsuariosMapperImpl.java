package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.AdministracionUsuariosDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.AdministracionUsuariosIDName;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AdministracionUsuariosMapperImpl implements AdministracionUsuariosMapper {

    @Override
    public UsuarioSelectDTO toUsuarioSelectDto(AdministracionUsuarios administracionUsuarios) {
        if ( administracionUsuarios == null ) {
            return null;
        }

        Long id = null;

        id = administracionUsuarios.getId();

        String nombreCompleto = administracionUsuarios.getNombres() + ' ' + administracionUsuarios.getApellidos();

        UsuarioSelectDTO usuarioSelectDTO = new UsuarioSelectDTO( id, nombreCompleto );

        return usuarioSelectDTO;
    }

    @Override
    public AdministracionUsuariosIDName toPartial(AdministracionUsuarios administracionUsuarios) {
        if ( administracionUsuarios == null ) {
            return null;
        }

        AdministracionUsuariosIDName administracionUsuariosIDName = new AdministracionUsuariosIDName();

        administracionUsuariosIDName.setId( administracionUsuarios.getId() );
        administracionUsuariosIDName.setNombres( administracionUsuarios.getNombres() );
        administracionUsuariosIDName.setApellidos( administracionUsuarios.getApellidos() );

        return administracionUsuariosIDName;
    }

    @Override
    public AdministracionUsuariosDTO toDto(AdministracionUsuarios administracionUsuarios) {
        if ( administracionUsuarios == null ) {
            return null;
        }

        AdministracionUsuariosDTO administracionUsuariosDTO = new AdministracionUsuariosDTO();

        administracionUsuariosDTO.setIdTipoIdentidad( administracionUsuariosTipoIdentidadId( administracionUsuarios ) );
        administracionUsuariosDTO.setIdSubtipoUsuario( administracionUsuariosSubtipoUsuarioId( administracionUsuarios ) );
        administracionUsuariosDTO.setIdPerfil( administracionUsuariosPerfilId( administracionUsuarios ) );
        administracionUsuariosDTO.setId( administracionUsuarios.getId() );
        administracionUsuariosDTO.setNombres( administracionUsuarios.getNombres() );
        administracionUsuariosDTO.setApellidos( administracionUsuarios.getApellidos() );
        administracionUsuariosDTO.setUsuario( administracionUsuarios.getUsuario() );
        administracionUsuariosDTO.setContraseña( administracionUsuarios.getContraseña() );
        administracionUsuariosDTO.setEmail( administracionUsuarios.getEmail() );
        administracionUsuariosDTO.setTelefono( administracionUsuarios.getTelefono() );
        administracionUsuariosDTO.setNumIdentidad( administracionUsuarios.getNumIdentidad() );

        administracionUsuariosDTO.setValorTipoIdentidad( administracionUsuarios.getTipoIdentidad() != null ? administracionUsuarios.getTipoIdentidad().getNombre() : null );
        administracionUsuariosDTO.setValorSubtipoUsuario( administracionUsuarios.getSubtipoUsuario() != null ? administracionUsuarios.getSubtipoUsuario().getNombre() : null );
        administracionUsuariosDTO.setValorPerfil( administracionUsuarios.getPerfil() != null ? administracionUsuarios.getPerfil().getNombre() : null );

        return administracionUsuariosDTO;
    }

    @Override
    public AdministracionUsuarios toEntity(AdministracionUsuariosDTO administracionUsuariosDTO) {
        if ( administracionUsuariosDTO == null ) {
            return null;
        }

        AdministracionUsuarios administracionUsuarios = new AdministracionUsuarios();

        administracionUsuarios.setId( administracionUsuariosDTO.getId() );
        administracionUsuarios.setUsuario( administracionUsuariosDTO.getUsuario() );
        administracionUsuarios.setContraseña( administracionUsuariosDTO.getContraseña() );
        administracionUsuarios.setNombres( administracionUsuariosDTO.getNombres() );
        administracionUsuarios.setApellidos( administracionUsuariosDTO.getApellidos() );
        administracionUsuarios.setNumIdentidad( administracionUsuariosDTO.getNumIdentidad() );
        administracionUsuarios.setTelefono( administracionUsuariosDTO.getTelefono() );
        administracionUsuarios.setEmail( administracionUsuariosDTO.getEmail() );

        return administracionUsuarios;
    }

    private Long administracionUsuariosTipoIdentidadId(AdministracionUsuarios administracionUsuarios) {
        if ( administracionUsuarios == null ) {
            return null;
        }
        UsuarioTiposIdentidad tipoIdentidad = administracionUsuarios.getTipoIdentidad();
        if ( tipoIdentidad == null ) {
            return null;
        }
        Long id = tipoIdentidad.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long administracionUsuariosSubtipoUsuarioId(AdministracionUsuarios administracionUsuarios) {
        if ( administracionUsuarios == null ) {
            return null;
        }
        UsuarioSubtipo subtipoUsuario = administracionUsuarios.getSubtipoUsuario();
        if ( subtipoUsuario == null ) {
            return null;
        }
        Long id = subtipoUsuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long administracionUsuariosPerfilId(AdministracionUsuarios administracionUsuarios) {
        if ( administracionUsuarios == null ) {
            return null;
        }
        UsuarioPerfil perfil = administracionUsuarios.getPerfil();
        if ( perfil == null ) {
            return null;
        }
        Long id = perfil.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
