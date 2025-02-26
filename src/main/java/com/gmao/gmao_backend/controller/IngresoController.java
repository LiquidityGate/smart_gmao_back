package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.IngresoDTO;
import com.gmao.gmao_backend.service.IngresoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<IngresoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        IngresoDTO filtros) {
        Page<IngresoDTO> dtoPage = ingresoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<IngresoDTO> getById(@PathVariable Long id) {
        return ingresoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<IngresoDTO> create(@RequestBody IngresoDTO ingresoDTO) {
        IngresoDTO savedIngreso = ingresoService.save(ingresoDTO);
        return ResponseEntity.ok(savedIngreso);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<IngresoDTO> update(@PathVariable Long id, @RequestBody IngresoDTO ingresoDTO) {
        ingresoDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return ingresoService.findById(id)
                .map(existingIngreso -> {
                    IngresoDTO updatedIngreso = ingresoService.update(id, ingresoDTO);
                    return ResponseEntity.ok(updatedIngreso);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ingresoService.findById(id).isPresent()) {
            ingresoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}