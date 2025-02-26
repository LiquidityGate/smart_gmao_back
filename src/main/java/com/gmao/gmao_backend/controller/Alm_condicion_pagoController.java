package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_condicion_pagoDTO;
import com.gmao.gmao_backend.service.Alm_condicion_pagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_condicion_pagos")
public class Alm_condicion_pagoController {

    private final Alm_condicion_pagoService alm_condicion_pagoService;

    public Alm_condicion_pagoController(Alm_condicion_pagoService alm_condicion_pagoService) {
        this.alm_condicion_pagoService = alm_condicion_pagoService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_condicion_pagoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_condicion_pagoDTO filtros) {
        Page<Alm_condicion_pagoDTO> dtoPage = alm_condicion_pagoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_condicion_pagoDTO> getById(@PathVariable Long id) {
        return alm_condicion_pagoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_condicion_pagoDTO> create(@RequestBody Alm_condicion_pagoDTO alm_condicion_pagoDTO) {
        Alm_condicion_pagoDTO savedAlm_condicion_pago = alm_condicion_pagoService.save(alm_condicion_pagoDTO);
        return ResponseEntity.ok(savedAlm_condicion_pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_condicion_pagoDTO> update(@PathVariable Long id, @RequestBody Alm_condicion_pagoDTO alm_condicion_pagoDTO) {
        alm_condicion_pagoDTO.setId(id);
        return alm_condicion_pagoService.findById(id)
                .map(existingAlm_condicion_pago -> {
                    Alm_condicion_pagoDTO updatedAlm_condicion_pago = alm_condicion_pagoService.update(id, alm_condicion_pagoDTO);
                    return ResponseEntity.ok(updatedAlm_condicion_pago);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_condicion_pagoService.findById(id).isPresent()) {
            alm_condicion_pagoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}