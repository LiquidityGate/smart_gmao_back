package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_usuarioRepository extends JpaRepository<Usu_usuario, Long>, JpaSpecificationExecutor<Usu_usuario> {
    Page<Usu_usuario> findAll(Pageable pageable);
}