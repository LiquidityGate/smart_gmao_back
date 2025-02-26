package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_motivoDTO;
import com.gmao.gmao_backend.service.Alm_motivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_motivos")
public class Alm_motivoController {

    private final Alm_motivoService alm_motivoService;

    public Alm_motivoController(Alm_motivoService alm_motivoService) {
        this.alm_motivoService = alm_motivoService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_motivoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_motivoDTO filtros) {
        Page<Alm_motivoDTO> dtoPage = alm_motivoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_motivoDTO> getById(@PathVariable Long id) {
        return alm_motivoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_motivoDTO> create(@RequestBody Alm_motivoDTO alm_motivoDTO) {
        Alm_motivoDTO savedAlm_motivo = alm_motivoService.save(alm_motivoDTO);
        return ResponseEntity.ok(savedAlm_motivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_motivoDTO> update(@PathVariable Long id, @RequestBody Alm_motivoDTO alm_motivoDTO) {
        alm_motivoDTO.setId(id);
        return alm_motivoService.findById(id)
                .map(existingAlm_motivo -> {
                    Alm_motivoDTO updatedAlm_motivo = alm_motivoService.update(id, alm_motivoDTO);
                    return ResponseEntity.ok(updatedAlm_motivo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_motivoService.findById(id).isPresent()) {
            alm_motivoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}