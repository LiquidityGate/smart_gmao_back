package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.UsuarioSubtipo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSubtipoRepository
        extends JpaRepository<UsuarioSubtipo, Long>, JpaSpecificationExecutor<UsuarioSubtipo> {
    Page<UsuarioSubtipo> findAll(Pageable pageable);
}