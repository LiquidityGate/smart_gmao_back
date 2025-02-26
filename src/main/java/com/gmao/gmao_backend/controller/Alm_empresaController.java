package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_empresaDTO;
import com.gmao.gmao_backend.service.Alm_empresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_empresas")
public class Alm_empresaController {

    private final Alm_empresaService alm_empresaService;

    public Alm_empresaController(Alm_empresaService alm_empresaService) {
        this.alm_empresaService = alm_empresaService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_empresaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_empresaDTO filtros) {
        Page<Alm_empresaDTO> dtoPage = alm_empresaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_empresaDTO> getById(@PathVariable Long id) {
        return alm_empresaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_empresaDTO> create(@RequestBody Alm_empresaDTO alm_empresaDTO) {
        Alm_empresaDTO savedAlm_empresa = alm_empresaService.save(alm_empresaDTO);
        return ResponseEntity.ok(savedAlm_empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_empresaDTO> update(@PathVariable Long id, @RequestBody Alm_empresaDTO alm_empresaDTO) {
        alm_empresaDTO.setId(id);
        return alm_empresaService.findById(id)
                .map(existingAlm_empresa -> {
                    Alm_empresaDTO updatedAlm_empresa = alm_empresaService.update(id, alm_empresaDTO);
                    return ResponseEntity.ok(updatedAlm_empresa);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_empresaService.findById(id).isPresent()) {
            alm_empresaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}