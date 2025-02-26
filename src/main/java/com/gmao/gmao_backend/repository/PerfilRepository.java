package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Perfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository
        extends JpaRepository<Perfil, Long>, JpaSpecificationExecutor<Perfil> {
    Page<Perfil> findAll(Pageable pageable); // Añadir este método para paginación
}