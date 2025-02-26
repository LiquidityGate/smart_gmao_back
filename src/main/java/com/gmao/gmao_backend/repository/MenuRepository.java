package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Menu;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository
                extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {

        // Consulta nativa con parámetros dinámicos
        @Query(value = "SELECT * FROM tbl_menus m " +
                        "WHERE m.estado = true AND (m.id IN " +
                        "(SELECT xp.id_menu FROM tbl_accesos_xperfil xp " +
                        "WHERE xp.estado = true AND xp.id_perfil = :idPerfil) OR " +
                        "m.id IN " +
                        "(SELECT xp.id_menu FROM tbl_accesos_xusuario xp " +
                        "WHERE xp.estado = true AND xp.id_usuario = :idUsuario)) " +
                        "AND (m.id NOT IN " +
                        "(SELECT xp.id_menu FROM tbl_accesos_xperfil xp " +
                        "WHERE xp.estado = false AND xp.id_perfil = :idPerfil) AND " +
                        "m.id NOT IN " +
                        "(SELECT xp.id_menu FROM tbl_accesos_xusuario xp " +
                        "WHERE xp.estado = false AND xp.id_usuario = :idUsuario)) " +
                        "ORDER BY m.orden ASC", nativeQuery = true)
        List<Menu> findMenusByPerfilAndUsuario(@Param("idPerfil") Long idPerfil, @Param("idUsuario") Long idUsuario);

        @Query(value = "SELECT * FROM tbl_menus m " +
                        "WHERE m.url = :url", nativeQuery = true)
        Optional<Menu> findMenusByURL(@Param("url") String url);

}