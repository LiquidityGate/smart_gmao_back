package com.gmao.gmao_backend.repository.AdministracionUsuarios;

import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaDietaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaLaboralDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaUsuarioDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosTablaDTO;
import com.gmao.gmao_backend.model.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoUsuariosRepository
                extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

        @Query("SELECT new com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosTablaDTO(u.id, u.nombres, u.apellidos, u.usuario, u.estado, u.correo, u.telefono, u.numIdentidad, u.tipoIdentidad.id, u.perfil.id, u.subtipo.id, u.empresa.id, u.tipoIdentidad.nombre, u.perfil.nombre, u.subtipo.nombre, u.empresa.nombre, null, u.cargo.id, u.cargo.nombre, u.turno.id, u.turno.turno, u.trabajando) "
                        +
                        "FROM Usuario u " +
                        "WHERE u.eliminado = false " +
                        "AND (:#{#filtro.idPerfil} IS NULL OR u.perfil.id = :#{#filtro.idPerfil}) " +
                        "AND (:#{#filtro.nombres} IS NULL OR u.nombres LIKE %:#{#filtro.nombres}%) " +
                        "AND (:#{#filtro.idIdentidad} IS NULL OR u.tipoIdentidad.id = :#{#filtro.idIdentidad}) ")
        Page<MantenimientoUsuariosTablaDTO> findTabla(
                        @Param("filtro") MantenimientoUsuariosTablaDTO filtro,
                        Pageable pageable);

        Optional<Usuario> findByUsuario(String usuario);

        @Query("SELECT new com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaUsuarioDTO(u.id, u.numIdentidad, u.tipoIdentidad.id, u.tipoIdentidad.nombre, u.nombres, u.apellidos, u.correo, u.telefono, u.perfil.id, u.perfil.nombre, u.subtipo.id, u.subtipo.nombre, u.empresa.id, u.empresa.nombre, u.estado, u.cargo.id, u.cargo.nombre, u.turno.id, u.turno.turno)"
                        +
                        "FROM Usuario u " +
                        "WHERE u.id = :idUsuario")
        List<MantenimientoUsuariosFichaUsuarioDTO> findFichaUsuario(@Param("idUsuario") Long idUsuario);

        @Query("SELECT new com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaLaboralDTO(u.id,u.fechaNacimiento,u.imei,u.equipo,u.carga,u.estadoPersonal,u.fechaInicio,u.fechaFin,u.tipoContrato,u.horasTrabajoAnuales,u.salarioBase,u.aportacionSistema,u.turnoLaboral,u.foto)"
                        +
                        "FROM Usuario u " +
                        "WHERE u.id = :idUsuario")
        List<MantenimientoUsuariosFichaLaboralDTO> findFichaLaboral(@Param("idUsuario") Long idUsuario);

        @Query("SELECT new com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaDietaDTO(ud.id,ud.idUsuario,ud.zona,ud.viatico,ud.importe,ud.creadoEn)"
                        +
                        "FROM UsuarioDieta ud " +
                        "WHERE ud.idUsuario = :idUsuario")
        Page<MantenimientoUsuariosFichaDietaDTO> findFichaDieta(@Param("idUsuario") Long idUsuario, Pageable pageable);

}