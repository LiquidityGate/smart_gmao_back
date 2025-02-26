package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_articuloRepository extends JpaRepository<Alm_articulo, Long>, JpaSpecificationExecutor<Alm_articulo> {
    Page<Alm_articulo> findAll(Pageable pageable);
}