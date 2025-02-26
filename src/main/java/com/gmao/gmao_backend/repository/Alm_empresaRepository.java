package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_empresaRepository extends JpaRepository<Alm_empresa, Long>, JpaSpecificationExecutor<Alm_empresa> {
    Page<Alm_empresa> findAll(Pageable pageable);
}