package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Familia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long>, JpaSpecificationExecutor<Familia> {
    Page<Familia> findAll(Pageable pageable);
}