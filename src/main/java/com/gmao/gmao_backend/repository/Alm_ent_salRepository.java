package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Alm_ent_sal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Alm_ent_salRepository extends JpaRepository<Alm_ent_sal, Long>, JpaSpecificationExecutor<Alm_ent_sal> {
    Page<Alm_ent_sal> findAll(Pageable pageable);
}