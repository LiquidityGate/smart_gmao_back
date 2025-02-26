package com.gmao.gmao_backend.service.Incidencias;

import com.gmao.gmao_backend.dto.Incidencias.IncidenciasDTO;
import com.gmao.gmao_backend.model.Incidencias.IncidenciaModel;
import com.gmao.gmao_backend.repository.Incidencias.IncidenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class IncidenciasService {

    @Autowired
    private IncidenciasRepository incidenciaRepository;

    public List<IncidenciaModel> listarTodas() {
        return incidenciaRepository.findAll();
    }

    public Optional<IncidenciaModel> buscarPorId(Long id) {
        return incidenciaRepository.findById(id);
    }

    public List<IncidenciaModel> buscarPorPrioridad(String prioridad) {
        return incidenciaRepository.findByPrioridad(prioridad);
    }

    public IncidenciaModel crearIncidencia(IncidenciasDTO dto) {
        IncidenciaModel incidencia = new IncidenciaModel();
        incidencia.setCodigoItem(dto.getCodigoItem());
        incidencia.setItem(dto.getItem());
        incidencia.setFechaCreacion(LocalDateTime.now());
        incidencia.setFechaCierre(dto.getFechaCierre());
        incidencia.setPrioridad(dto.getPrioridad());
        incidencia.setEstado(dto.getEstado());
        incidencia.setOtOrigen(dto.getOtOrigen());
        incidencia.setOtGenerada(dto.getOtGenerada());
        incidencia.setCreadoPor("admin");
        incidencia.setFechaCreado(LocalDateTime.now());
        return incidenciaRepository.save(incidencia);
    }

    public void eliminarIncidencia(Long id) {
        Optional<IncidenciaModel> incidenciaOpt = incidenciaRepository.findById(id);
        if (incidenciaOpt.isPresent()) {
            IncidenciaModel incidencia = incidenciaOpt.get();
            incidencia.setEliminadoPor("admin");
            incidencia.setFechaEliminado(LocalDateTime.now());
            incidenciaRepository.save(incidencia);
        } else {
            throw new EntityNotFoundException("Incidencia no encontrada");
        }
    }
}
