package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.TipoIdentidad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIdentidadRepository
        extends JpaRepository<TipoIdentidad, Long>, JpaSpecificationExecutor<TipoIdentidad> {
    Page<TipoIdentidad> findAll(Pageable pageable); // Añadir este método para paginación
}