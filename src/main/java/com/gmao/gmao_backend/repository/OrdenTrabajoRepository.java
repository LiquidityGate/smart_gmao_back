package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.OrdenTrabajo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long>, JpaSpecificationExecutor<OrdenTrabajo> {
    @EntityGraph(attributePaths = {"solicitante"})
    Page<OrdenTrabajo> findAll(Specification<OrdenTrabajo> spec, Pageable pageable);
}