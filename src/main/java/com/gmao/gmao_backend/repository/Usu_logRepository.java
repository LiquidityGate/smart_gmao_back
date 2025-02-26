package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_logRepository extends JpaRepository<Usu_log, Long>, JpaSpecificationExecutor<Usu_log> {
    Page<Usu_log> findAll(Pageable pageable);
}