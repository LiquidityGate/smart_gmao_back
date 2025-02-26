package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_motivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_motivoRepository extends JpaRepository<Alm_motivo, Long>, JpaSpecificationExecutor<Alm_motivo> {
    Page<Alm_motivo> findAll(Pageable pageable);
}