package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Marcas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long>, JpaSpecificationExecutor<Marcas> {
    Page<Marcas> findAll(Pageable pageable);
}

