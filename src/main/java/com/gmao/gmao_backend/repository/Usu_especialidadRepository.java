package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_especialidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_especialidadRepository extends JpaRepository<Usu_especialidad, Long>, JpaSpecificationExecutor<Usu_especialidad> {
    Page<Usu_especialidad> findAll(Pageable pageable);
}