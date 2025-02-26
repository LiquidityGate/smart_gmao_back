package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Dispositivo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
    Page<Dispositivo> findAll(Pageable pageable);
}