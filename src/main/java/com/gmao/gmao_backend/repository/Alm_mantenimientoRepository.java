package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_mantenimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_mantenimientoRepository extends JpaRepository<Alm_mantenimiento, Long>, JpaSpecificationExecutor<Alm_mantenimiento> {
    Page<Alm_mantenimiento> findAll(Pageable pageable);
}