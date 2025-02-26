package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.model.UsuarioPerfil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPerfilRepository
                extends JpaRepository<UsuarioPerfil, Long>, JpaSpecificationExecutor<UsuarioPerfil> {

        @Query("SELECT new com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO(p.id, p.nombre, p.descripcion, p.estado, "
                        +
                        "p.creadoEn, p.creadoPor, CONCAT(u1.nombres, ' ', u1.apellidos), p.actualizadoEn, p.actualizadoPor, CONCAT(u2.nombres, ' ', u2.apellidos), p.estadoEliminado) "
                        +
                        "FROM UsuarioPerfil p " +
                        "LEFT JOIN Usuario u1 ON p.creadoPor = u1.id " +
                        "LEFT JOIN Usuario u2 ON p.actualizadoPor = u2.id " +
                        "WHERE p.estadoEliminado = false AND (LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))")
        Page<MantenimientoPerfilesDTO> findAllDTO(Pageable pageable, @Param("nombre") String nombre);

        @Query("SELECT new com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO(p.id, p.nombre, p.descripcion, p.estado, "
                        +
                        "p.creadoEn, p.creadoPor, CONCAT(u1.nombres, ' ', u1.apellidos), p.actualizadoEn, p.actualizadoPor, CONCAT(u2.nombres, ' ', u2.apellidos), p.estadoEliminado) "
                        +
                        "FROM UsuarioPerfil p " +
                        "LEFT JOIN Usuario u1 ON p.creadoPor = u1.id " +
                        "LEFT JOIN Usuario u2 ON p.actualizadoPor = u2.id " +
                        "WHERE p.estadoEliminado = false AND p.id = :id")
        MantenimientoPerfilesDTO findDTOById(@Param("id") Long id);

        Page<UsuarioPerfil> findAll(Pageable pageable); // Añadir este método para paginación
}