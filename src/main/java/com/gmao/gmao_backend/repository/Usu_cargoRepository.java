package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_cargoRepository extends JpaRepository<Usu_cargo, Long>, JpaSpecificationExecutor<Usu_cargo> {
    Page<Usu_cargo> findAll(Pageable pageable);
}