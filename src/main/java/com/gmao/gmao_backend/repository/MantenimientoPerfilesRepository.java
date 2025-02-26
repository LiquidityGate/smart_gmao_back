package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.model.UsuarioPerfil;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoPerfilesRepository extends JpaRepository<UsuarioPerfil, Long> {

        @Query("SELECT new com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO(p.id, p.nombre, p.descripcion, p.estado, "
                        +
                        "p.creadoEn, p.creadoPor, CONCAT(u1.nombres, ' ', u1.apellidos), p.actualizadoEn, p.actualizadoPor, CONCAT(u2.nombres, ' ', u2.apellidos), p.estadoEliminado) "
                        +
                        "FROM UsuarioPerfil p " +
                        "LEFT JOIN Usuario u1 ON p.creadoPor = u1.id " +
                        "LEFT JOIN Usuario u2 ON p.actualizadoPor = u2.id " +
                        "WHERE p.id = :idPerfil")
        List<MantenimientoPerfilesDTO> findDatosPerfil(@Param("idPerfil") Long idPerfil);

        @Query(value = "SELECT m.id, m.nombre, m.menu_padre, m.sub_menu_padre, m.url, m.orden, m.icono, (SELECT xp.estado FROM tbl_accesos_xperfil xp WHERE xp.id_menu = m.id AND xp.id_perfil=:idPerfil LIMIT 1) AS estado, (SELECT xp.id FROM tbl_accesos_xperfil xp WHERE xp.id_menu = m.id AND xp.id_perfil=:idPerfil LIMIT 1) AS id_acceso_xperfil, (SELECT xp.crear FROM tbl_accesos_xperfil xp WHERE xp.id_menu = m.id AND xp.id_perfil=:idPerfil LIMIT 1) AS crear, (SELECT xp.ver FROM tbl_accesos_xperfil xp WHERE xp.id_menu = m.id AND xp.id_perfil=:idPerfil LIMIT 1) AS ver, (SELECT xp.editar FROM tbl_accesos_xperfil xp WHERE xp.id_menu = m.id AND xp.id_perfil=:idPerfil LIMIT 1) AS editar, (SELECT xp.eliminar FROM tbl_accesos_xperfil xp WHERE xp.id_menu = m.id AND xp.id_perfil=:idPerfil LIMIT 1) AS eliminar "
                        +
                        "FROM tbl_menus m " +
                        "WHERE m.estado = true " +
                        "ORDER BY m.orden ASC", nativeQuery = true)
        List<Object[]> findMenusByPerfil(@Param("idPerfil") Long idPerfil);

}