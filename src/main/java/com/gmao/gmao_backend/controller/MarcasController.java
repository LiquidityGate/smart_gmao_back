package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.MarcasDTO;
import com.gmao.gmao_backend.service.MarcasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/marcas")
public class MarcasController {

    private final MarcasService marcasService;

    public MarcasController(MarcasService marcasService) {
        this.marcasService = marcasService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<MarcasDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        MarcasDTO filtros) {
        Page<MarcasDTO> dtoPage = marcasService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<MarcasDTO> getById(@PathVariable Long id) {
        return marcasService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<MarcasDTO> create(@RequestBody MarcasDTO marcasDTO) {
        MarcasDTO savedOrden = marcasService.save(marcasDTO);
        return ResponseEntity.ok(savedOrden);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<MarcasDTO> update(@PathVariable Long id, @RequestBody MarcasDTO marcasDTO) {
        marcasDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return marcasService.findById(id)
                .map(existingOrden -> {
                    MarcasDTO updatedOrden = marcasService.update(id, marcasDTO);
                    return ResponseEntity.ok(updatedOrden);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (marcasService.findById(id).isPresent()) {
            marcasService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}