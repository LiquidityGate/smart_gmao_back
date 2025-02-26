package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_categoriaRepository extends JpaRepository<Alm_categoria, Long>, JpaSpecificationExecutor<Alm_categoria> {
    Page<Alm_categoria> findAll(Pageable pageable);
}