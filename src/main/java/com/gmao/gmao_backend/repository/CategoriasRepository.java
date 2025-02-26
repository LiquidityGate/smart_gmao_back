package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Categorias;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>, JpaSpecificationExecutor<Categorias> {

    Page<Categorias> findAll(Specification<Categorias> spec, Pageable pageable);

    List<Categorias> findAll(Specification<Categorias> spec); 
    
    List<Categorias> findByEstadoNot(String estado);
}

