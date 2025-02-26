package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.ArticuloDTO;
import com.gmao.gmao_backend.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<ArticuloDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        ArticuloDTO filtros) {
        Page<ArticuloDTO> dtoPage = articuloService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDTO> getById(@PathVariable Long id) {
        return articuloService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<ArticuloDTO> create(@RequestBody ArticuloDTO articuloDTO) {
        ArticuloDTO savedArticulo = articuloService.save(articuloDTO);
        return ResponseEntity.ok(savedArticulo);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<ArticuloDTO> update(@PathVariable Long id, @RequestBody ArticuloDTO articuloDTO) {
        articuloDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return articuloService.findById(id)
                .map(existingArticulo -> {
                    ArticuloDTO updatedArticulo = articuloService.update(id, articuloDTO);
                    return ResponseEntity.ok(updatedArticulo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (articuloService.findById(id).isPresent()) {
            articuloService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}