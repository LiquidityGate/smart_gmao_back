package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_actividadDTO;
import com.gmao.gmao_backend.service.Usu_actividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_actividades")
public class Usu_actividadController {

    private final Usu_actividadService usu_actividadService;

    public Usu_actividadController(Usu_actividadService usu_actividadService) {
        this.usu_actividadService = usu_actividadService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_actividadDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_actividadDTO filtros) {
        Page<Usu_actividadDTO> dtoPage = usu_actividadService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_actividadDTO> getById(@PathVariable Long id) {
        return usu_actividadService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_actividadDTO> create(@RequestBody Usu_actividadDTO usu_actividadDTO) {
        Usu_actividadDTO savedUsu_actividad = usu_actividadService.save(usu_actividadDTO);
        return ResponseEntity.ok(savedUsu_actividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_actividadDTO> update(@PathVariable Long id, @RequestBody Usu_actividadDTO usu_actividadDTO) {
        usu_actividadDTO.setId(id);
        return usu_actividadService.findById(id)
                .map(existingUsu_actividad -> {
                    Usu_actividadDTO updatedUsu_actividad = usu_actividadService.update(id, usu_actividadDTO);
                    return ResponseEntity.ok(updatedUsu_actividad);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_actividadService.findById(id).isPresent()) {
            usu_actividadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}