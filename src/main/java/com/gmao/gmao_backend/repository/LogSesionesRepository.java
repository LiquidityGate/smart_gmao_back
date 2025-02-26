package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.LogSesiones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogSesionesRepository extends JpaRepository<LogSesiones, Long> {

}