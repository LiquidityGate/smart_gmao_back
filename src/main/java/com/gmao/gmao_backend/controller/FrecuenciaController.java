package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.FrecuenciaDTO;
import com.gmao.gmao_backend.service.FrecuenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/frecuencia")
public class FrecuenciaController {

    private final FrecuenciaService frecuenciaService;

    public FrecuenciaController(FrecuenciaService frecuenciaService) {
        this.frecuenciaService = frecuenciaService;
    }

    // Obtener todas las frecuencias con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<FrecuenciaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        FrecuenciaDTO filtros) {
        Page<FrecuenciaDTO> dtoPage = frecuenciaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener todas las frecuencias sin paginación
    @GetMapping("/all")
    public ResponseEntity<List<FrecuenciaDTO>> getAllWithoutPagination(FrecuenciaDTO filtros) {
        List<FrecuenciaDTO> dtoList = frecuenciaService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    // Obtener todas las frecuencias para un combobox
    @GetMapping("/combo")
    public ResponseEntity<List<FrecuenciaDTO>> getFrecuenciasForCombo() {
        List<FrecuenciaDTO> frecuencias = frecuenciaService.findAllForCombo();
        return ResponseEntity.ok(frecuencias);
    }

    // Obtener una frecuencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<FrecuenciaDTO> getById(@PathVariable Long id) {
        return frecuenciaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva frecuencia
    @PostMapping
    public ResponseEntity<FrecuenciaDTO> create(@RequestBody FrecuenciaDTO frecuenciaDTO) {
        FrecuenciaDTO savedFrecuencia = frecuenciaService.save(frecuenciaDTO);
        return ResponseEntity.ok(savedFrecuencia);
    }

    // Actualizar una frecuencia existente
    @PutMapping("/{id}")
    public ResponseEntity<FrecuenciaDTO> update(@PathVariable Long id, @RequestBody FrecuenciaDTO frecuenciaDTO) {
        frecuenciaDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return frecuenciaService.findById(id)
                .map(existingFrecuencia -> {
                    FrecuenciaDTO updatedFrecuencia = frecuenciaService.update(id, frecuenciaDTO);
                    return ResponseEntity.ok(updatedFrecuencia);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una frecuencia por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (frecuenciaService.findById(id).isPresent()) {
            frecuenciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}