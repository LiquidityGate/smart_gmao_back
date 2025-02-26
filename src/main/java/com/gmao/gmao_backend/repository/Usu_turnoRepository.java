package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_turno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_turnoRepository extends JpaRepository<Usu_turno, Long>, JpaSpecificationExecutor<Usu_turno> {
    Page<Usu_turno> findAll(Pageable pageable);
}