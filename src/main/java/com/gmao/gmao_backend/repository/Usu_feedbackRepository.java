package com.gmao.gmao_backend.repository;

import com.gmao.gmao_backend.model.Usu_feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Usu_feedbackRepository extends JpaRepository<Usu_feedback, Long>, JpaSpecificationExecutor<Usu_feedback> {
    Page<Usu_feedback> findAll(Pageable pageable);
}