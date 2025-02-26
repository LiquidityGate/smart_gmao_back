package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Usuario, Long> {

        @Query(value = "SELECT ax.estado from tbl_accesos_xperfil ax "
                        +
                        "LEFT JOIN tbl_menus m on ax.id_menu = m.id " +
                        "WHERE m.url=:url AND m.estado = true AND ax.id_perfil=:idPerfil ", nativeQuery = true)
        List<Object[]> findAccesoMenu(@Param("url") String url, @Param("idPerfil") Long idPerfil);

        @Query(value = "SELECT m.url, ax.id_perfil, ax.estado, ax.crear, ax.ver, ax.editar, ax.eliminar from tbl_accesos_xperfil ax "
                        +
                        "LEFT JOIN tbl_menus m on ax.id_menu = m.id " +
                        "WHERE m.url=:url AND m.estado = true AND ax.id_perfil=:idPerfil ", nativeQuery = true)
        List<Object[]> findPermisosMenu(@Param("url") String url, @Param("idPerfil") Long idPerfil);

}