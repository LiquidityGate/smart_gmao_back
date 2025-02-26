package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Salida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long>, JpaSpecificationExecutor<Salida> {
    Page<Salida> findAll(Pageable pageable);
}