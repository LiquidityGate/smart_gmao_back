package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_subtipoDTO;
import com.gmao.gmao_backend.service.Alm_subtipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_subtipos")
public class Alm_subtipoController {

    private final Alm_subtipoService alm_subtipoService;

    public Alm_subtipoController(Alm_subtipoService alm_subtipoService) {
        this.alm_subtipoService = alm_subtipoService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_subtipoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_subtipoDTO filtros) {
        Page<Alm_subtipoDTO> dtoPage = alm_subtipoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_subtipoDTO> getById(@PathVariable Long id) {
        return alm_subtipoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_subtipoDTO> create(@RequestBody Alm_subtipoDTO alm_subtipoDTO) {
        Alm_subtipoDTO savedAlm_subtipo = alm_subtipoService.save(alm_subtipoDTO);
        return ResponseEntity.ok(savedAlm_subtipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_subtipoDTO> update(@PathVariable Long id, @RequestBody Alm_subtipoDTO alm_subtipoDTO) {
        alm_subtipoDTO.setId(id);
        return alm_subtipoService.findById(id)
                .map(existingAlm_subtipo -> {
                    Alm_subtipoDTO updatedAlm_subtipo = alm_subtipoService.update(id, alm_subtipoDTO);
                    return ResponseEntity.ok(updatedAlm_subtipo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_subtipoService.findById(id).isPresent()) {
            alm_subtipoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}