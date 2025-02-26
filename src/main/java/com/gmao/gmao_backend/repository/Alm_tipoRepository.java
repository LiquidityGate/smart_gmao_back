package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_tipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_tipoRepository extends JpaRepository<Alm_tipo, Long>, JpaSpecificationExecutor<Alm_tipo> {
    Page<Alm_tipo> findAll(Pageable pageable);
}