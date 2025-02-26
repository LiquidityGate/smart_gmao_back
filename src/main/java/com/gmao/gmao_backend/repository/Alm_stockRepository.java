package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_stockRepository extends JpaRepository<Alm_stock, Long>, JpaSpecificationExecutor<Alm_stock> {
    Page<Alm_stock> findAll(Pageable pageable);
}