package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.TipoReprogramacion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReprogramacionRepository extends JpaRepository<TipoReprogramacion, Long>, JpaSpecificationExecutor<TipoReprogramacion> {

    // Búsqueda paginada con especificaciones dinámicas
    Page<TipoReprogramacion> findAll(Specification<TipoReprogramacion> spec, Pageable pageable);

    // Búsqueda completa con especificaciones dinámicas
    List<TipoReprogramacion> findAll(Specification<TipoReprogramacion> spec);

    // Buscar todos los tipos de reprogramaciones excluyendo las de un estado específico
    List<TipoReprogramacion> findByEstadoNot(String estado);
}