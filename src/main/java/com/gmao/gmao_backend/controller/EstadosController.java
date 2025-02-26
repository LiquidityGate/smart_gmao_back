package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.EstadosDTO;
import com.gmao.gmao_backend.service.EstadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/estados")
public class EstadosController {

    private final EstadosService estadosService;

    public EstadosController(EstadosService estadosService) {
        this.estadosService = estadosService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<EstadosDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        EstadosDTO filtros) {
        Page<EstadosDTO> dtoPage = estadosService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadosDTO> getById(@PathVariable Long id) {
        return estadosService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<EstadosDTO> create(@RequestBody EstadosDTO estadosDTO) {
        EstadosDTO savedOrden = estadosService.save(estadosDTO);
        return ResponseEntity.ok(savedOrden);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<EstadosDTO> update(@PathVariable Long id, @RequestBody EstadosDTO estadosDTO) {
        estadosDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return estadosService.findById(id)
                .map(existingOrden -> {
                    EstadosDTO updatedOrden = estadosService.update(id, estadosDTO);
                    return ResponseEntity.ok(updatedOrden);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (estadosService.findById(id).isPresent()) {
            estadosService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}