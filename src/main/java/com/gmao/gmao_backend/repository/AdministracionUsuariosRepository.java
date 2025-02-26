package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.AdministracionUsuarios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministracionUsuariosRepository
        extends JpaRepository<AdministracionUsuarios, Long>, JpaSpecificationExecutor<AdministracionUsuarios> {
    Page<AdministracionUsuarios> findAll(Pageable pageable); // Añadir este método para paginación
    
    Optional<AdministracionUsuarios> findByUsuario(String usuario);
}