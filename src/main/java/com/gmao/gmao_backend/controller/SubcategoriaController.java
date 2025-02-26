package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.SubcategoriaDTO;
import com.gmao.gmao_backend.service.SubcategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/subcategorias")
public class SubcategoriaController {

    private final SubcategoriaService subcategoriaService;

    public SubcategoriaController(SubcategoriaService subcategoriaService) {
        this.subcategoriaService = subcategoriaService;
    }

    // Obtener todas las subcategorías con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<SubcategoriaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        SubcategoriaDTO filtros) {
        Page<SubcategoriaDTO> dtoPage = subcategoriaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubcategoriaDTO>> getAllWithoutPagination(SubcategoriaDTO filtros) {
        List<SubcategoriaDTO> dtoList = subcategoriaService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    // Obtener una subcategoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<SubcategoriaDTO> getById(@PathVariable Long id) {
        return subcategoriaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva subcategoría
    @PostMapping
    public ResponseEntity<SubcategoriaDTO> create(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        SubcategoriaDTO savedSubcategoria = subcategoriaService.save(subcategoriaDTO);
        return ResponseEntity.ok(savedSubcategoria);
    }

    // Actualizar una subcategoría existente
    @PutMapping("/{id}")
    public ResponseEntity<SubcategoriaDTO> update(@PathVariable Long id, @RequestBody SubcategoriaDTO subcategoriaDTO) {
        subcategoriaDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return subcategoriaService.findById(id)
                .map(existingSubcategoria -> {
                    SubcategoriaDTO updatedSubcategoria = subcategoriaService.update(id, subcategoriaDTO);
                    return ResponseEntity.ok(updatedSubcategoria);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una subcategoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (subcategoriaService.findById(id).isPresent()) {
            subcategoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}