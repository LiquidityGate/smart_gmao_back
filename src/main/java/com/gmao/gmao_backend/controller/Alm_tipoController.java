package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_tipoDTO;
import com.gmao.gmao_backend.service.Alm_tipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_tipos")
public class Alm_tipoController {

    private final Alm_tipoService alm_tipoService;

    public Alm_tipoController(Alm_tipoService alm_tipoService) {
        this.alm_tipoService = alm_tipoService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_tipoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_tipoDTO filtros) {
        Page<Alm_tipoDTO> dtoPage = alm_tipoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_tipoDTO> getById(@PathVariable Long id) {
        return alm_tipoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_tipoDTO> create(@RequestBody Alm_tipoDTO alm_tipoDTO) {
        Alm_tipoDTO savedAlm_tipo = alm_tipoService.save(alm_tipoDTO);
        return ResponseEntity.ok(savedAlm_tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_tipoDTO> update(@PathVariable Long id, @RequestBody Alm_tipoDTO alm_tipoDTO) {
        alm_tipoDTO.setId(id);
        return alm_tipoService.findById(id)
                .map(existingAlm_tipo -> {
                    Alm_tipoDTO updatedAlm_tipo = alm_tipoService.update(id, alm_tipoDTO);
                    return ResponseEntity.ok(updatedAlm_tipo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_tipoService.findById(id).isPresent()) {
            alm_tipoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}