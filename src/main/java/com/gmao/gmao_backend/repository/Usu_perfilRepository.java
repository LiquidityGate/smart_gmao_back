package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_perfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_perfilRepository extends JpaRepository<Usu_perfil, Long>, JpaSpecificationExecutor<Usu_perfil> {
    Page<Usu_perfil> findAll(Pageable pageable);
}