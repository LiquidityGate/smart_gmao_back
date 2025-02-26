package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_privilegio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_privilegioRepository extends JpaRepository<Usu_privilegio, Long>, JpaSpecificationExecutor<Usu_privilegio> {
    Page<Usu_privilegio> findAll(Pageable pageable);
}