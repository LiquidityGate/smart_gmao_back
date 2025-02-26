package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.SubfamiliaDTO;
import com.gmao.gmao_backend.service.SubfamiliaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/subfamilias")
public class SubfamiliaController {

    private final SubfamiliaService familiaService;

    public SubfamiliaController(SubfamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<SubfamiliaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        SubfamiliaDTO filtros) {
        Page<SubfamiliaDTO> dtoPage = familiaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<SubfamiliaDTO> getById(@PathVariable Long id) {
        return familiaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<SubfamiliaDTO> create(@RequestBody SubfamiliaDTO familiaDTO) {
        SubfamiliaDTO savedSubfamilia = familiaService.save(familiaDTO);
        return ResponseEntity.ok(savedSubfamilia);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<SubfamiliaDTO> update(@PathVariable Long id, @RequestBody SubfamiliaDTO familiaDTO) {
        familiaDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return familiaService.findById(id)
                .map(existingSubfamilia -> {
                    SubfamiliaDTO updatedSubfamilia = familiaService.update(id, familiaDTO);
                    return ResponseEntity.ok(updatedSubfamilia);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (familiaService.findById(id).isPresent()) {
            familiaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}