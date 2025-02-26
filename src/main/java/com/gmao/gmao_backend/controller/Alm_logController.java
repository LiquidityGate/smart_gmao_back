package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_logDTO;
import com.gmao.gmao_backend.service.Alm_logService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_logs")
public class Alm_logController {

    private final Alm_logService alm_logService;

    public Alm_logController(Alm_logService alm_logService) {
        this.alm_logService = alm_logService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_logDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_logDTO filtros) {
        Page<Alm_logDTO> dtoPage = alm_logService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_logDTO> getById(@PathVariable Long id) {
        return alm_logService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_logDTO> create(@RequestBody Alm_logDTO alm_logDTO) {
        Alm_logDTO savedAlm_log = alm_logService.save(alm_logDTO);
        return ResponseEntity.ok(savedAlm_log);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_logDTO> update(@PathVariable Long id, @RequestBody Alm_logDTO alm_logDTO) {
        alm_logDTO.setId(id);
        return alm_logService.findById(id)
                .map(existingAlm_log -> {
                    Alm_logDTO updatedAlm_log = alm_logService.update(id, alm_logDTO);
                    return ResponseEntity.ok(updatedAlm_log);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_logService.findById(id).isPresent()) {
            alm_logService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}