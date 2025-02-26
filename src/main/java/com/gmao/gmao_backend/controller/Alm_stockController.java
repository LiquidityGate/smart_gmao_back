package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_stockDTO;
import com.gmao.gmao_backend.service.Alm_stockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_stocks")
public class Alm_stockController {

    private final Alm_stockService alm_stockService;

    public Alm_stockController(Alm_stockService alm_stockService) {
        this.alm_stockService = alm_stockService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_stockDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_stockDTO filtros) {
        Page<Alm_stockDTO> dtoPage = alm_stockService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_stockDTO> getById(@PathVariable Long id) {
        return alm_stockService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_stockDTO> create(@RequestBody Alm_stockDTO alm_stockDTO) {
        Alm_stockDTO savedAlm_stock = alm_stockService.save(alm_stockDTO);
        return ResponseEntity.ok(savedAlm_stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_stockDTO> update(@PathVariable Long id, @RequestBody Alm_stockDTO alm_stockDTO) {
        alm_stockDTO.setId(id);
        return alm_stockService.findById(id)
                .map(existingAlm_stock -> {
                    Alm_stockDTO updatedAlm_stock = alm_stockService.update(id, alm_stockDTO);
                    return ResponseEntity.ok(updatedAlm_stock);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_stockService.findById(id).isPresent()) {
            alm_stockService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}