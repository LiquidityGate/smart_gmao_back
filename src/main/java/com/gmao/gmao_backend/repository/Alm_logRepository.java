package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_logRepository extends JpaRepository<Alm_log, Long>, JpaSpecificationExecutor<Alm_log> {
    Page<Alm_log> findAll(Pageable pageable);
}