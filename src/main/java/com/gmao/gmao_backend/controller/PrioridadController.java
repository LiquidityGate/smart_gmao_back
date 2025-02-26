package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.PrioridadDTO;
import com.gmao.gmao_backend.service.PrioridadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/prioridad")
public class PrioridadController {

    private final PrioridadService prioridadService;

    public PrioridadController(PrioridadService prioridadService) {
        this.prioridadService = prioridadService;
    }

    // Obtener todas las prioridades con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<PrioridadDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        PrioridadDTO filtros) {
        Page<PrioridadDTO> dtoPage = prioridadService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener todas las prioridades sin paginación
    @GetMapping("/all")
    public ResponseEntity<List<PrioridadDTO>> getAllWithoutPagination(PrioridadDTO filtros) {
        List<PrioridadDTO> dtoList = prioridadService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    // Obtener todas las prioridades para un combobox
    @GetMapping("/combo")
    public ResponseEntity<List<PrioridadDTO>> getPrioridadesForCombo() {
        List<PrioridadDTO> prioridades = prioridadService.findAllForCombo();
        return ResponseEntity.ok(prioridades);
    }

    // Obtener una prioridad por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrioridadDTO> getById(@PathVariable Long id) {
        return prioridadService.findById(id)
                               .map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva prioridad
    @PostMapping
    public ResponseEntity<PrioridadDTO> create(@RequestBody PrioridadDTO prioridadDTO) {
        PrioridadDTO savedPrioridad = prioridadService.save(prioridadDTO);
        return ResponseEntity.ok(savedPrioridad);
    }

    // Actualizar una prioridad existente
    @PutMapping("/{id}")
    public ResponseEntity<PrioridadDTO> update(@PathVariable Long id, @RequestBody PrioridadDTO prioridadDTO) {
        prioridadDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return prioridadService.findById(id)
                .map(existingPrioridad -> {
                    PrioridadDTO updatedPrioridad = prioridadService.update(id, prioridadDTO);
                    return ResponseEntity.ok(updatedPrioridad);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una prioridad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (prioridadService.findById(id).isPresent()) {
            prioridadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}