package com.gmao.gmao_backend.repository.O.T;




import com.gmao.gmao_backend.model.O.T.OrdenesTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenesTrabajoRepository extends JpaRepository<OrdenesTrabajo, Long> {
    /**
     * Busca todas las órdenes de trabajo de un tipo específico
     */
    List<OrdenesTrabajo> findByTipo(String tipo);
}