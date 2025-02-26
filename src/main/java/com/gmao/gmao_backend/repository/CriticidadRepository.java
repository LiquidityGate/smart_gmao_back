package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Criticidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CriticidadRepository extends JpaRepository<Criticidad, Long>, JpaSpecificationExecutor<Criticidad> {
    Page<Criticidad> findAll(Pageable pageable);
}

