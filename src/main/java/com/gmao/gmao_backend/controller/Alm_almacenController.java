package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_almacenDTO;
import com.gmao.gmao_backend.service.Alm_almacenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_almacenes")
public class Alm_almacenController {

    private final Alm_almacenService alm_almacenService;

    public Alm_almacenController(Alm_almacenService alm_almacenService) {
        this.alm_almacenService = alm_almacenService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_almacenDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection, Alm_almacenDTO filtros) {
        Page<Alm_almacenDTO> dtoPage = alm_almacenService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_almacenDTO> getById(@PathVariable Long id) {
        return alm_almacenService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_almacenDTO> create(@RequestBody Alm_almacenDTO alm_almacenDTO) {
        Alm_almacenDTO savedAlm_almacen = alm_almacenService.save(alm_almacenDTO);
        return ResponseEntity.ok(savedAlm_almacen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_almacenDTO> update(@PathVariable Long id, @RequestBody Alm_almacenDTO alm_almacenDTO) {
        alm_almacenDTO.setId(id);
        return alm_almacenService.findById(id).map(existingAlm_almacen -> { 
            Alm_almacenDTO updatedAlm_almacen = alm_almacenService.update(id, alm_almacenDTO);
                return ResponseEntity.ok(updatedAlm_almacen);
            }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_almacenService.findById(id).isPresent()) {
            alm_almacenService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}