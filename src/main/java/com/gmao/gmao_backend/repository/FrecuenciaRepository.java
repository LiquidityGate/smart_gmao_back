package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Frecuencia;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FrecuenciaRepository extends JpaRepository<Frecuencia, Long>, JpaSpecificationExecutor<Frecuencia> {

    // Búsqueda paginada con especificaciones dinámicas
    Page<Frecuencia> findAll(Specification<Frecuencia> spec, Pageable pageable);

    // Búsqueda completa con especificaciones dinámicas
    List<Frecuencia> findAll(Specification<Frecuencia> spec);

    // Buscar todas las frecuencias excluyendo las de un estado específico
    List<Frecuencia> findByEstadoNot(String estado);
}