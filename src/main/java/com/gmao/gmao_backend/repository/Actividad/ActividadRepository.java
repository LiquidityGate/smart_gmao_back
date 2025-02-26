package com.gmao.gmao_backend.repository.Actividad;

import com.gmao.gmao_backend.model.Actividad.ActividadModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<ActividadModel, Long> {
}
