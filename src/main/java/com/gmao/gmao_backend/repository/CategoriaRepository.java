package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Categoria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {

    Page<Categoria> findAll(Specification<Categoria> spec, Pageable pageable);

    List<Categoria> findAll(Specification<Categoria> spec); 
    
    List<Categoria> findByEstadoNot(String estado);
}