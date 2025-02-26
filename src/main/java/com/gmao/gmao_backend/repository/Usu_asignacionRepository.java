package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_asignacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_asignacionRepository extends JpaRepository<Usu_asignacion, Long>, JpaSpecificationExecutor<Usu_asignacion> {
    Page<Usu_asignacion> findAll(Pageable pageable);
}