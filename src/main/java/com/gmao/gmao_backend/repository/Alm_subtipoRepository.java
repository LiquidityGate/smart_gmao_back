package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_subtipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_subtipoRepository extends JpaRepository<Alm_subtipo, Long>, JpaSpecificationExecutor<Alm_subtipo> {
    Page<Alm_subtipo> findAll(Pageable pageable);
}