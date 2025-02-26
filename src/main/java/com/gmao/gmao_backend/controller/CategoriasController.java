package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.CategoriasDTO;
import com.gmao.gmao_backend.service.CategoriasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    private final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    // Obtener todas las categorías con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<CategoriasDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        CategoriasDTO filtros) {
        Page<CategoriasDTO> dtoPage = categoriasService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriasDTO>> getAllWithoutPagination(CategoriasDTO filtros) {
        List<CategoriasDTO> dtoList = categoriasService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/combo")
    public ResponseEntity<List<CategoriasDTO>> getCategoriasForCombo() {
        List<CategoriasDTO> categorias = categoriasService.findAllForCombo();
        return ResponseEntity.ok(categorias);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriasDTO> getById(@PathVariable Long id) {
        return categoriasService.findById(id)
                               .map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<CategoriasDTO> create(@RequestBody CategoriasDTO categoriasDTO) {
        CategoriasDTO savedCategorias = categoriasService.save(categoriasDTO);
        return ResponseEntity.ok(savedCategorias);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<CategoriasDTO> update(@PathVariable Long id, @RequestBody CategoriasDTO categoriasDTO) {
        categoriasDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return categoriasService.findById(id)
                .map(existingCategorias -> {
                    CategoriasDTO updatedCategorias = categoriasService.update(id, categoriasDTO);
                    return ResponseEntity.ok(updatedCategorias);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (categoriasService.findById(id).isPresent()) {
            categoriasService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

