package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Subtipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtipoRepository extends JpaRepository<Subtipo, Long>, JpaSpecificationExecutor<Subtipo> {
    Page<Subtipo> findAll(Pageable pageable);
}

