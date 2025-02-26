package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.TipoReprogramacionDTO;
import com.gmao.gmao_backend.service.TipoReprogramacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/tipo-reprogramacion")
public class TipoReprogramacionController {

    private final TipoReprogramacionService tipoReprogramacionService;

    public TipoReprogramacionController(TipoReprogramacionService tipoReprogramacionService) {
        this.tipoReprogramacionService = tipoReprogramacionService;
    }

    // Obtener todas las reprogramaciones con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<TipoReprogramacionDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        TipoReprogramacionDTO filtros) {
        Page<TipoReprogramacionDTO> dtoPage = tipoReprogramacionService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener todas las reprogramaciones sin paginación
    @GetMapping("/all")
    public ResponseEntity<List<TipoReprogramacionDTO>> getAllWithoutPagination(TipoReprogramacionDTO filtros) {
        List<TipoReprogramacionDTO> dtoList = tipoReprogramacionService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    // Obtener todas las reprogramaciones para un combobox
    @GetMapping("/combo")
    public ResponseEntity<List<TipoReprogramacionDTO>> getTiposReprogramacionForCombo() {
        List<TipoReprogramacionDTO> tiposReprogramacion = tipoReprogramacionService.findAllForCombo();
        return ResponseEntity.ok(tiposReprogramacion);
    }

    // Obtener una reprogramación por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoReprogramacionDTO> getById(@PathVariable Long id) {
        return tipoReprogramacionService.findById(id)
                                        .map(ResponseEntity::ok)
                                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva reprogramación
    @PostMapping
    public ResponseEntity<TipoReprogramacionDTO> create(@RequestBody TipoReprogramacionDTO tipoReprogramacionDTO) {
        TipoReprogramacionDTO savedTipoReprogramacion = tipoReprogramacionService.save(tipoReprogramacionDTO);
        return ResponseEntity.ok(savedTipoReprogramacion);
    }

    // Actualizar una reprogramación existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoReprogramacionDTO> update(@PathVariable Long id, @RequestBody TipoReprogramacionDTO tipoReprogramacionDTO) {
        tipoReprogramacionDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return tipoReprogramacionService.findById(id)
                .map(existingTipoReprogramacion -> {
                    TipoReprogramacionDTO updatedTipoReprogramacion = tipoReprogramacionService.update(id, tipoReprogramacionDTO);
                    return ResponseEntity.ok(updatedTipoReprogramacion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una reprogramación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (tipoReprogramacionService.findById(id).isPresent()) {
            tipoReprogramacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}