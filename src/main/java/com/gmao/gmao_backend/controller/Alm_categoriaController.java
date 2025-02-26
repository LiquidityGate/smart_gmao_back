package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_categoriaDTO;
import com.gmao.gmao_backend.service.Alm_categoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_categorias")
public class Alm_categoriaController {

    private final Alm_categoriaService alm_categoriaService;

    public Alm_categoriaController(Alm_categoriaService alm_categoriaService) {
        this.alm_categoriaService = alm_categoriaService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_categoriaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_categoriaDTO filtros) {
        Page<Alm_categoriaDTO> dtoPage = alm_categoriaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_categoriaDTO> getById(@PathVariable Long id) {
        return alm_categoriaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_categoriaDTO> create(@RequestBody Alm_categoriaDTO alm_categoriaDTO) {
        Alm_categoriaDTO savedAlm_categoria = alm_categoriaService.save(alm_categoriaDTO);
        return ResponseEntity.ok(savedAlm_categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_categoriaDTO> update(@PathVariable Long id, @RequestBody Alm_categoriaDTO alm_categoriaDTO) {
        alm_categoriaDTO.setId(id);
        return alm_categoriaService.findById(id)
                .map(existingAlm_categoria -> {
                    Alm_categoriaDTO updatedAlm_categoria = alm_categoriaService.update(id, alm_categoriaDTO);
                    return ResponseEntity.ok(updatedAlm_categoria);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_categoriaService.findById(id).isPresent()) {
            alm_categoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}