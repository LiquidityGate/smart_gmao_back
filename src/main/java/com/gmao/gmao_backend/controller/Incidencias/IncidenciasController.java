package com.gmao.gmao_backend.controller.Incidencias;

import com.gmao.gmao_backend.dto.Incidencias.IncidenciasDTO;
import com.gmao.gmao_backend.model.Incidencias.IncidenciaModel;
import com.gmao.gmao_backend.service.Incidencias.IncidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciasController {

    @Autowired
    private IncidenciasService incidenciaService;

    @GetMapping
    public List<IncidenciaModel> obtenerTodas() {
        return incidenciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaModel> obtenerPorId(@PathVariable Long id) {
        Optional<IncidenciaModel> incidencia = incidenciaService.buscarPorId(id);
        return incidencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/prioridad/{prioridad}")
    public List<IncidenciaModel> obtenerPorPrioridad(@PathVariable String prioridad) {
        return incidenciaService.buscarPorPrioridad(prioridad);
    }

    @PostMapping
    public ResponseEntity<IncidenciaModel> crear(@RequestBody IncidenciasDTO dto) {
        IncidenciaModel nuevaIncidencia = incidenciaService.crearIncidencia(dto);
        return ResponseEntity.ok(nuevaIncidencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        incidenciaService.eliminarIncidencia(id);
        return ResponseEntity.noContent().build();
    }
}
