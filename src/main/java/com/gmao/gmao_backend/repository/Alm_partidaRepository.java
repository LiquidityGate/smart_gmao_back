package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_partidaRepository extends JpaRepository<Alm_partida, Long>, JpaSpecificationExecutor<Alm_partida> {
    Page<Alm_partida> findAll(Pageable pageable);
}