package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.OrdenTrabajoDTO;
import com.gmao.gmao_backend.service.OrdenTrabajoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/ordenes-trabajo")
public class OrdenTrabajoController {

    private final OrdenTrabajoService ordenTrabajoService;

    public OrdenTrabajoController(OrdenTrabajoService ordenTrabajoService) {
        this.ordenTrabajoService = ordenTrabajoService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<OrdenTrabajoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        OrdenTrabajoDTO filtros) {
        Page<OrdenTrabajoDTO> dtoPage = ordenTrabajoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajoDTO> getById(@PathVariable Long id) {
        return ordenTrabajoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<OrdenTrabajoDTO> create(@RequestBody OrdenTrabajoDTO ordenTrabajoDTO) {
        OrdenTrabajoDTO savedOrden = ordenTrabajoService.save(ordenTrabajoDTO);
        return ResponseEntity.ok(savedOrden);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdenTrabajoDTO> update(@PathVariable Long id, @RequestBody OrdenTrabajoDTO ordenTrabajoDTO) {
        ordenTrabajoDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return ordenTrabajoService.findById(id)
                .map(existingOrden -> {
                    OrdenTrabajoDTO updatedOrden = ordenTrabajoService.update(id, ordenTrabajoDTO);
                    return ResponseEntity.ok(updatedOrden);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ordenTrabajoService.findById(id).isPresent()) {
            ordenTrabajoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}