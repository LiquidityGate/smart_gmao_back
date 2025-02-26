package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.UsuarioDieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDietaRepository
                extends JpaRepository<UsuarioDieta, Long>, JpaSpecificationExecutor<UsuarioDieta> {

}