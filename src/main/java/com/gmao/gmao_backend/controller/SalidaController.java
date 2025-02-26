package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.SalidaDTO;
import com.gmao.gmao_backend.service.SalidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/salidas")
public class SalidaController {

    private final SalidaService salidaService;

    public SalidaController(SalidaService salidaService) {
        this.salidaService = salidaService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<SalidaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        SalidaDTO filtros) {
        Page<SalidaDTO> dtoPage = salidaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<SalidaDTO> getById(@PathVariable Long id) {
        return salidaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<SalidaDTO> create(@RequestBody SalidaDTO salidaDTO) {
        SalidaDTO savedSalida = salidaService.save(salidaDTO);
        return ResponseEntity.ok(savedSalida);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<SalidaDTO> update(@PathVariable Long id, @RequestBody SalidaDTO salidaDTO) {
        salidaDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return salidaService.findById(id)
                .map(existingSalida -> {
                    SalidaDTO updatedSalida = salidaService.update(id, salidaDTO);
                    return ResponseEntity.ok(updatedSalida);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (salidaService.findById(id).isPresent()) {
            salidaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}