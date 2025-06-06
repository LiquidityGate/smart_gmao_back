package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_almacen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_almacenRepository extends JpaRepository<Alm_almacen, Long>, JpaSpecificationExecutor<Alm_almacen> {
    Page<Alm_almacen> findAll(Pageable pageable);
}