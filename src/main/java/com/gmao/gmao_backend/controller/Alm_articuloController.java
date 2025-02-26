package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_articuloDTO;
import com.gmao.gmao_backend.service.Alm_articuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_articulos")
public class Alm_articuloController {

    private final Alm_articuloService alm_articuloService;

    public Alm_articuloController(Alm_articuloService alm_articuloService) {
        this.alm_articuloService = alm_articuloService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_articuloDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_articuloDTO filtros) {
        Page<Alm_articuloDTO> dtoPage = alm_articuloService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_articuloDTO> getById(@PathVariable Long id) {
        return alm_articuloService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_articuloDTO> create(@RequestBody Alm_articuloDTO alm_articuloDTO) {
        Alm_articuloDTO savedAlm_articulo = alm_articuloService.save(alm_articuloDTO);
        return ResponseEntity.ok(savedAlm_articulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_articuloDTO> update(@PathVariable Long id, @RequestBody Alm_articuloDTO alm_articuloDTO) {
        alm_articuloDTO.setId(id);
        return alm_articuloService.findById(id)
                .map(existingAlm_articulo -> {
                    Alm_articuloDTO updatedAlm_articulo = alm_articuloService.update(id, alm_articuloDTO);
                    return ResponseEntity.ok(updatedAlm_articulo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_articuloService.findById(id).isPresent()) {
            alm_articuloService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}