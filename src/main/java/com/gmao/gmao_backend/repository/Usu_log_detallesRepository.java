package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_log_detalles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_log_detallesRepository 
extends JpaRepository<Usu_log_detalles, Long>, JpaSpecificationExecutor<Usu_log_detalles> {

        // Consulta nativa con parámetros dinámicos
        @Query(value = "SELECT * FROM vg_usu_log_detalles v " +
                        "WHERE (:creado_por IS NULL OR v.creado_por = :creado_por) " +
                        "ORDER BY " +
                        "CASE WHEN :sortField = 'creado_en' AND :sortDir = 'DESC' THEN v.creado_en END DESC, " +
                        "CASE WHEN :sortField = 'creado_en' AND :sortDir = 'ASC' THEN v.creado_en END ASC, " +
                        "CASE WHEN :sortField = 'creado_por' AND :sortDir = 'DESC' THEN v.creado_por END DESC, " +
                        "CASE WHEN :sortField = 'creado_por' AND :sortDir = 'ASC' THEN v.creado_por END ASC, " +
                        "CASE WHEN :sortField = 'ruta' AND :sortDir = 'DESC' THEN v.ruta END DESC, " +
                        "CASE WHEN :sortField = 'ruta' AND :sortDir = 'ASC' THEN v.ruta END ASC, " +
                        "CASE WHEN :sortField = 'ip_address' AND :sortDir = 'DESC' THEN v.ip_address END DESC, " +
                        "CASE WHEN :sortField = 'ip_address' AND :sortDir = 'ASC' THEN v.ip_address END ASC, " +
                        "CASE WHEN :sortField = 'user_agent' AND :sortDir = 'DESC' THEN v.user_agent END DESC, " +
                        "CASE WHEN :sortField = 'user_agent' AND :sortDir = 'ASC' THEN v.user_agent END ASC", 
                        nativeQuery = true)
        Page<Usu_log_detalles> findUsu_log_detallesByCreadoPor(
            @Param("creado_por") Long creado_por,
            @Param("sortField") String sortField,
            @Param("sortDir") String sortDir,
            Pageable pageable);
}
