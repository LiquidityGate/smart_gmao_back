package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_proveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_proveedorRepository extends JpaRepository<Alm_proveedor, Long>, JpaSpecificationExecutor<Alm_proveedor> {
    Page<Alm_proveedor> findAll(Pageable pageable);
}