package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.CriticidadDTO;
import com.gmao.gmao_backend.service.CriticidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/criticidad")
public class CriticidadController {

    private final CriticidadService criticidadService;

    public CriticidadController(CriticidadService criticidadService) {
        this.criticidadService = criticidadService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<CriticidadDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        CriticidadDTO filtros) {
        Page<CriticidadDTO> dtoPage = criticidadService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<CriticidadDTO> getById(@PathVariable Long id) {
        return criticidadService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<CriticidadDTO> create(@RequestBody CriticidadDTO criticidadDTO) {
        CriticidadDTO savedOrden = criticidadService.save(criticidadDTO);
        return ResponseEntity.ok(savedOrden);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<CriticidadDTO> update(@PathVariable Long id, @RequestBody CriticidadDTO criticidadDTO) {
        criticidadDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return criticidadService.findById(id)
                .map(existingOrden -> {
                    CriticidadDTO updatedOrden = criticidadService.update(id, criticidadDTO);
                    return ResponseEntity.ok(updatedOrden);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (criticidadService.findById(id).isPresent()) {
            criticidadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}