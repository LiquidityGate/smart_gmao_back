package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_proveedorDTO;
import com.gmao.gmao_backend.service.Alm_proveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_proveedores")
public class Alm_proveedorController {

    private final Alm_proveedorService alm_proveedorService;

    public Alm_proveedorController(Alm_proveedorService alm_proveedorService) {
        this.alm_proveedorService = alm_proveedorService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_proveedorDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_proveedorDTO filtros) {
        Page<Alm_proveedorDTO> dtoPage = alm_proveedorService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_proveedorDTO> getById(@PathVariable Long id) {
        return alm_proveedorService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_proveedorDTO> create(@RequestBody Alm_proveedorDTO alm_proveedorDTO) {
        Alm_proveedorDTO savedAlm_proveedor = alm_proveedorService.save(alm_proveedorDTO);
        return ResponseEntity.ok(savedAlm_proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_proveedorDTO> update(@PathVariable Long id, @RequestBody Alm_proveedorDTO alm_proveedorDTO) {
        alm_proveedorDTO.setId(id);
        return alm_proveedorService.findById(id)
                .map(existingAlm_proveedor -> {
                    Alm_proveedorDTO updatedAlm_proveedor = alm_proveedorService.update(id, alm_proveedorDTO);
                    return ResponseEntity.ok(updatedAlm_proveedor);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_proveedorService.findById(id).isPresent()) {
            alm_proveedorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}