package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Subcategoria;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long>, JpaSpecificationExecutor<Subcategoria> {
    
    @EntityGraph(attributePaths = {"categoria"})
    Page<Subcategoria> findAll(Specification<Subcategoria> spec, Pageable pageable);

    List<Subcategoria> findAll(Specification<Subcategoria> spec);   
}