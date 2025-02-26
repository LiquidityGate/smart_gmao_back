package com.gmao.gmao_backend.repository.Incidencias;

import com.gmao.gmao_backend.model.Incidencias.IncidenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenciasRepository extends JpaRepository<IncidenciaModel, Long> {
    List<IncidenciaModel> findByPrioridad(String prioridad);
}
