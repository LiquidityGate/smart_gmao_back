package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.ActividadGestion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadGestionRepository
        extends JpaRepository<ActividadGestion, Long>, JpaSpecificationExecutor<ActividadGestion> {
    @NonNull
    Page<ActividadGestion> findAll(@Nullable Specification<ActividadGestion> spec, @NonNull Pageable pageable);

}