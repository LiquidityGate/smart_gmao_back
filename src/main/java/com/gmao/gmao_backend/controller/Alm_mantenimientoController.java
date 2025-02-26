package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_mantenimientoDTO;
import com.gmao.gmao_backend.service.Alm_mantenimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_mantenimientos")
public class Alm_mantenimientoController {

    private final Alm_mantenimientoService alm_mantenimientoService;

    public Alm_mantenimientoController(Alm_mantenimientoService alm_mantenimientoService) {
        this.alm_mantenimientoService = alm_mantenimientoService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_mantenimientoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_mantenimientoDTO filtros) {
        Page<Alm_mantenimientoDTO> dtoPage = alm_mantenimientoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_mantenimientoDTO> getById(@PathVariable Long id) {
        return alm_mantenimientoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_mantenimientoDTO> create(@RequestBody Alm_mantenimientoDTO alm_mantenimientoDTO) {
        Alm_mantenimientoDTO savedAlm_mantenimiento = alm_mantenimientoService.save(alm_mantenimientoDTO);
        return ResponseEntity.ok(savedAlm_mantenimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_mantenimientoDTO> update(@PathVariable Long id, @RequestBody Alm_mantenimientoDTO alm_mantenimientoDTO) {
        alm_mantenimientoDTO.setId(id);
        return alm_mantenimientoService.findById(id)
                .map(existingAlm_mantenimiento -> {
                    Alm_mantenimientoDTO updatedAlm_mantenimiento = alm_mantenimientoService.update(id, alm_mantenimientoDTO);
                    return ResponseEntity.ok(updatedAlm_mantenimiento);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_mantenimientoService.findById(id).isPresent()) {
            alm_mantenimientoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}