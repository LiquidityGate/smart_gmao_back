package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_actividad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_actividadRepository extends JpaRepository<Usu_actividad, Long>, JpaSpecificationExecutor<Usu_actividad> {
    Page<Usu_actividad> findAll(Pageable pageable);
}