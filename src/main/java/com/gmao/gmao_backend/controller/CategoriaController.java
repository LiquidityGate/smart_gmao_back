package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.CategoriaDTO;
import com.gmao.gmao_backend.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Obtener todas las categorías con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<CategoriaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        CategoriaDTO filtros) {
        Page<CategoriaDTO> dtoPage = categoriaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDTO>> getAllWithoutPagination(CategoriaDTO filtros) {
        List<CategoriaDTO> dtoList = categoriaService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/combo")
    public ResponseEntity<List<CategoriaDTO>> getCategoriasForCombo() {
        List<CategoriaDTO> categorias = categoriaService.findAllForCombo();
        return ResponseEntity.ok(categorias);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id) {
        return categoriaService.findById(id)
                               .map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO savedCategoria = categoriaService.save(categoriaDTO);
        return ResponseEntity.ok(savedCategoria);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return categoriaService.findById(id)
                .map(existingCategoria -> {
                    CategoriaDTO updatedCategoria = categoriaService.update(id, categoriaDTO);
                    return ResponseEntity.ok(updatedCategoria);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (categoriaService.findById(id).isPresent()) {
            categoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}