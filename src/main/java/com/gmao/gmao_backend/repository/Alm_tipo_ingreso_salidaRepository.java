package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_tipo_ingreso_salida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_tipo_ingreso_salidaRepository extends JpaRepository<Alm_tipo_ingreso_salida, Long>, JpaSpecificationExecutor<Alm_tipo_ingreso_salida> {
    Page<Alm_tipo_ingreso_salida> findAll(Pageable pageable);
}