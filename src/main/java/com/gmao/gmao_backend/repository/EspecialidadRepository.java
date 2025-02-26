package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Especialidad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>, JpaSpecificationExecutor<Especialidad> {

    // Búsqueda paginada con especificaciones dinámicas
    Page<Especialidad> findAll(Specification<Especialidad> spec, Pageable pageable);

    // Búsqueda completa con especificaciones dinámicas
    List<Especialidad> findAll(Specification<Especialidad> spec);

    // Buscar todas las especialidades excluyendo las de un estado específico
    List<Especialidad> findByEstadoNot(String estado);
}