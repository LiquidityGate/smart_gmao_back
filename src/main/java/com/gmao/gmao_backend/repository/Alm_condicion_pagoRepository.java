package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_condicion_pago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_condicion_pagoRepository extends JpaRepository<Alm_condicion_pago, Long>, JpaSpecificationExecutor<Alm_condicion_pago> {
    Page<Alm_condicion_pago> findAll(Pageable pageable);
}