package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.LogModulos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogModulosRepository extends JpaRepository<LogModulos, Long> {

}