package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Prioridad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadRepository extends JpaRepository<Prioridad, Long>, JpaSpecificationExecutor<Prioridad> {

    // Búsqueda paginada con especificaciones dinámicas
    Page<Prioridad> findAll(Specification<Prioridad> spec, Pageable pageable);

    // Búsqueda completa con especificaciones dinámicas
    List<Prioridad> findAll(Specification<Prioridad> spec);

    // Buscar todas las prioridades excluyendo las de un estado específico
    List<Prioridad> findByEstadoNot(String estado);
}