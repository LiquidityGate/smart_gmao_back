package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository
        extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {
    Page<Empresa> findAll(Pageable pageable);
}