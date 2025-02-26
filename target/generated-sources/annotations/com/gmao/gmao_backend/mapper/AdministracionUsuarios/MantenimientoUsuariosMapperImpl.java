package com.gmao.gmao_backend.mapper.AdministracionUsuarios;

import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaDietaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaLaboralDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaUsuarioDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosTablaDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.model.UsuarioDieta;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MantenimientoUsuariosMapperImpl implements MantenimientoUsuariosMapper {

    @Override
    public MantenimientoUsuariosTablaDTO toDtoTabla(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        MantenimientoUsuariosTablaDTO mantenimientoUsuariosTablaDTO = new MantenimientoUsuariosTablaDTO();

        mantenimientoUsuariosTablaDTO.setValorPerfil( usuarioPerfilNombre( usuario ) );
        mantenimientoUsuariosTablaDTO.setId( usuario.getId() );
        mantenimientoUsuariosTablaDTO.setNombres( usuario.getNombres() );
        mantenimientoUsuariosTablaDTO.setApellidos( usuario.getApellidos() );
        mantenimientoUsuariosTablaDTO.setUsuario( usuario.getUsuario() );
        mantenimientoUsuariosTablaDTO.setEstado( usuario.getEstado() );
        mantenimientoUsuariosTablaDTO.setCorreo( usuario.getCorreo() );
        mantenimientoUsuariosTablaDTO.setTelefono( usuario.getTelefono() );
        mantenimientoUsuariosTablaDTO.setNumIdentidad( usuario.getNumIdentidad() );
        mantenimientoUsuariosTablaDTO.setIdIdentidad( usuario.getIdIdentidad() );
        mantenimientoUsuariosTablaDTO.setIdPerfil( usuario.getIdPerfil() );
        mantenimientoUsuariosTablaDTO.setIdSubtipo( usuario.getIdSubtipo() );
        mantenimientoUsuariosTablaDTO.setIdEmpresa( usuario.getIdEmpresa() );
        mantenimientoUsuariosTablaDTO.setContraseña( usuario.getContraseña() );
        mantenimientoUsuariosTablaDTO.setIdCargo( usuario.getIdCargo() );
        mantenimientoUsuariosTablaDTO.setIdTurno( usuario.getIdTurno() );
        mantenimientoUsuariosTablaDTO.setTrabajando( usuario.getTrabajando() );

        return mantenimientoUsuariosTablaDTO;
    }

    @Override
    public Usuario toEntityTabla(MantenimientoUsuariosTablaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setUsuario( dto.getUsuario() );
        usuario.setContraseña( dto.getContraseña() );
        usuario.setNombres( dto.getNombres() );
        usuario.setApellidos( dto.getApellidos() );
        usuario.setNumIdentidad( dto.getNumIdentidad() );
        usuario.setIdIdentidad( dto.getIdIdentidad() );
        usuario.setTelefono( dto.getTelefono() );
        usuario.setCorreo( dto.getCorreo() );
        usuario.setEstado( dto.getEstado() );
        usuario.setIdSubtipo( dto.getIdSubtipo() );
        usuario.setIdPerfil( dto.getIdPerfil() );
        usuario.setIdEmpresa( dto.getIdEmpresa() );
        usuario.setIdCargo( dto.getIdCargo() );
        usuario.setIdTurno( dto.getIdTurno() );
        usuario.setTrabajando( dto.getTrabajando() );

        return usuario;
    }

    @Override
    public void updateFromDto(MantenimientoUsuariosTablaDTO dto, Usuario entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUsuario() != null ) {
            entity.setUsuario( dto.getUsuario() );
        }
        if ( dto.getContraseña() != null ) {
            entity.setContraseña( dto.getContraseña() );
        }
        if ( dto.getNombres() != null ) {
            entity.setNombres( dto.getNombres() );
        }
        if ( dto.getApellidos() != null ) {
            entity.setApellidos( dto.getApellidos() );
        }
        if ( dto.getNumIdentidad() != null ) {
            entity.setNumIdentidad( dto.getNumIdentidad() );
        }
        if ( dto.getIdIdentidad() != null ) {
            entity.setIdIdentidad( dto.getIdIdentidad() );
        }
        if ( dto.getTelefono() != null ) {
            entity.setTelefono( dto.getTelefono() );
        }
        if ( dto.getCorreo() != null ) {
            entity.setCorreo( dto.getCorreo() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getIdSubtipo() != null ) {
            entity.setIdSubtipo( dto.getIdSubtipo() );
        }
        if ( dto.getIdPerfil() != null ) {
            entity.setIdPerfil( dto.getIdPerfil() );
        }
        if ( dto.getIdEmpresa() != null ) {
            entity.setIdEmpresa( dto.getIdEmpresa() );
        }
        if ( dto.getIdCargo() != null ) {
            entity.setIdCargo( dto.getIdCargo() );
        }
        if ( dto.getIdTurno() != null ) {
            entity.setIdTurno( dto.getIdTurno() );
        }
        if ( dto.getTrabajando() != null ) {
            entity.setTrabajando( dto.getTrabajando() );
        }
    }

    @Override
    public MantenimientoUsuariosFichaUsuarioDTO toDtoFichaUsuario(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        MantenimientoUsuariosFichaUsuarioDTO mantenimientoUsuariosFichaUsuarioDTO = new MantenimientoUsuariosFichaUsuarioDTO();

        mantenimientoUsuariosFichaUsuarioDTO.setId( usuario.getId() );
        mantenimientoUsuariosFichaUsuarioDTO.setNumIdentidad( usuario.getNumIdentidad() );
        mantenimientoUsuariosFichaUsuarioDTO.setIdIdentidad( usuario.getIdIdentidad() );
        mantenimientoUsuariosFichaUsuarioDTO.setNombres( usuario.getNombres() );
        mantenimientoUsuariosFichaUsuarioDTO.setApellidos( usuario.getApellidos() );
        mantenimientoUsuariosFichaUsuarioDTO.setCorreo( usuario.getCorreo() );
        mantenimientoUsuariosFichaUsuarioDTO.setTelefono( usuario.getTelefono() );
        mantenimientoUsuariosFichaUsuarioDTO.setIdPerfil( usuario.getIdPerfil() );
        mantenimientoUsuariosFichaUsuarioDTO.setIdSubtipo( usuario.getIdSubtipo() );
        mantenimientoUsuariosFichaUsuarioDTO.setIdEmpresa( usuario.getIdEmpresa() );
        mantenimientoUsuariosFichaUsuarioDTO.setEstado( usuario.getEstado() );
        mantenimientoUsuariosFichaUsuarioDTO.setIdCargo( usuario.getIdCargo() );
        mantenimientoUsuariosFichaUsuarioDTO.setIdTurno( usuario.getIdTurno() );

        return mantenimientoUsuariosFichaUsuarioDTO;
    }

    @Override
    public void updateFromMantenimientoUsuariosFichaUsuarioDTO(MantenimientoUsuariosFichaUsuarioDTO dto, Usuario entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombres() != null ) {
            entity.setNombres( dto.getNombres() );
        }
        if ( dto.getApellidos() != null ) {
            entity.setApellidos( dto.getApellidos() );
        }
        if ( dto.getNumIdentidad() != null ) {
            entity.setNumIdentidad( dto.getNumIdentidad() );
        }
        if ( dto.getIdIdentidad() != null ) {
            entity.setIdIdentidad( dto.getIdIdentidad() );
        }
        if ( dto.getTelefono() != null ) {
            entity.setTelefono( dto.getTelefono() );
        }
        if ( dto.getCorreo() != null ) {
            entity.setCorreo( dto.getCorreo() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getIdSubtipo() != null ) {
            entity.setIdSubtipo( dto.getIdSubtipo() );
        }
        if ( dto.getIdPerfil() != null ) {
            entity.setIdPerfil( dto.getIdPerfil() );
        }
        if ( dto.getIdEmpresa() != null ) {
            entity.setIdEmpresa( dto.getIdEmpresa() );
        }
        if ( dto.getIdCargo() != null ) {
            entity.setIdCargo( dto.getIdCargo() );
        }
        if ( dto.getIdTurno() != null ) {
            entity.setIdTurno( dto.getIdTurno() );
        }
    }

    @Override
    public MantenimientoUsuariosFichaLaboralDTO toDtoFichaLaboral(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        MantenimientoUsuariosFichaLaboralDTO mantenimientoUsuariosFichaLaboralDTO = new MantenimientoUsuariosFichaLaboralDTO();

        mantenimientoUsuariosFichaLaboralDTO.setId( usuario.getId() );
        mantenimientoUsuariosFichaLaboralDTO.setFechaNacimiento( usuario.getFechaNacimiento() );
        mantenimientoUsuariosFichaLaboralDTO.setImei( usuario.getImei() );
        mantenimientoUsuariosFichaLaboralDTO.setEquipo( usuario.getEquipo() );
        mantenimientoUsuariosFichaLaboralDTO.setCarga( usuario.getCarga() );
        mantenimientoUsuariosFichaLaboralDTO.setEstadoPersonal( usuario.getEstadoPersonal() );
        mantenimientoUsuariosFichaLaboralDTO.setFechaInicio( usuario.getFechaInicio() );
        mantenimientoUsuariosFichaLaboralDTO.setFechaFin( usuario.getFechaFin() );
        mantenimientoUsuariosFichaLaboralDTO.setTipoContrato( usuario.getTipoContrato() );
        mantenimientoUsuariosFichaLaboralDTO.setHorasTrabajoAnuales( usuario.getHorasTrabajoAnuales() );
        mantenimientoUsuariosFichaLaboralDTO.setSalarioBase( usuario.getSalarioBase() );
        mantenimientoUsuariosFichaLaboralDTO.setAportacionSistema( usuario.getAportacionSistema() );
        mantenimientoUsuariosFichaLaboralDTO.setTurnoLaboral( usuario.getTurnoLaboral() );
        mantenimientoUsuariosFichaLaboralDTO.setFoto( usuario.getFoto() );

        return mantenimientoUsuariosFichaLaboralDTO;
    }

    @Override
    public void updateFromMantenimientoUsuariosFichaLaboralDTO(MantenimientoUsuariosFichaLaboralDTO dto, Usuario entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getFechaNacimiento() != null ) {
            entity.setFechaNacimiento( dto.getFechaNacimiento() );
        }
        if ( dto.getImei() != null ) {
            entity.setImei( dto.getImei() );
        }
        if ( dto.getEquipo() != null ) {
            entity.setEquipo( dto.getEquipo() );
        }
        if ( dto.getCarga() != null ) {
            entity.setCarga( dto.getCarga() );
        }
        if ( dto.getEstadoPersonal() != null ) {
            entity.setEstadoPersonal( dto.getEstadoPersonal() );
        }
        if ( dto.getFechaInicio() != null ) {
            entity.setFechaInicio( dto.getFechaInicio() );
        }
        if ( dto.getFechaFin() != null ) {
            entity.setFechaFin( dto.getFechaFin() );
        }
        if ( dto.getTipoContrato() != null ) {
            entity.setTipoContrato( dto.getTipoContrato() );
        }
        if ( dto.getHorasTrabajoAnuales() != null ) {
            entity.setHorasTrabajoAnuales( dto.getHorasTrabajoAnuales() );
        }
        if ( dto.getSalarioBase() != null ) {
            entity.setSalarioBase( dto.getSalarioBase() );
        }
        if ( dto.getAportacionSistema() != null ) {
            entity.setAportacionSistema( dto.getAportacionSistema() );
        }
        if ( dto.getTurnoLaboral() != null ) {
            entity.setTurnoLaboral( dto.getTurnoLaboral() );
        }
        if ( dto.getFoto() != null ) {
            entity.setFoto( dto.getFoto() );
        }
    }

    @Override
    public UsuarioDieta toEntityFichaDietaDTO(MantenimientoUsuariosFichaDietaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioDieta usuarioDieta = new UsuarioDieta();

        usuarioDieta.setId( dto.getId() );
        usuarioDieta.setIdUsuario( dto.getIdUsuario() );
        usuarioDieta.setZona( dto.getZona() );
        usuarioDieta.setViatico( dto.getViatico() );
        usuarioDieta.setImporte( dto.getImporte() );
        usuarioDieta.setCreadoEn( dto.getCreadoEn() );

        return usuarioDieta;
    }

    private String usuarioPerfilNombre(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        UsuarioPerfil perfil = usuario.getPerfil();
        if ( perfil == null ) {
            return null;
        }
        String nombre = perfil.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
