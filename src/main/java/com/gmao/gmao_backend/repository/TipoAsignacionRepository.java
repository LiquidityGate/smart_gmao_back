package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.TipoAsignacion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAsignacionRepository
        extends JpaRepository<TipoAsignacion, Long>, JpaSpecificationExecutor<TipoAsignacion> {
    @NonNull
    Page<TipoAsignacion> findAll(@Nullable Specification<TipoAsignacion> spec, @NonNull Pageable pageable);

}