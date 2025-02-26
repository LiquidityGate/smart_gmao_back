package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.LogMovimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMovimientoRepository extends JpaRepository<LogMovimiento, Long> {

}