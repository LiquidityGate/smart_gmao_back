package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.OrdenCompraDTO;
import com.gmao.gmao_backend.service.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/orden_compras")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<OrdenCompraDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        OrdenCompraDTO filtros) {
        Page<OrdenCompraDTO> dtoPage = ordenCompraService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener una orden de trabajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompraDTO> getById(@PathVariable Long id) {
        return ordenCompraService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva orden de trabajo
    @PostMapping
    public ResponseEntity<OrdenCompraDTO> create(@RequestBody OrdenCompraDTO ordenCompraDTO) {
        OrdenCompraDTO savedOrdenCompra = ordenCompraService.save(ordenCompraDTO);
        return ResponseEntity.ok(savedOrdenCompra);
    }

    // Actualizar una orden de trabajo existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompraDTO> update(@PathVariable Long id, @RequestBody OrdenCompraDTO ordenCompraDTO) {
        ordenCompraDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return ordenCompraService.findById(id)
                .map(existingOrdenCompra -> {
                    OrdenCompraDTO updatedOrdenCompra = ordenCompraService.update(id, ordenCompraDTO);
                    return ResponseEntity.ok(updatedOrdenCompra);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una orden de trabajo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ordenCompraService.findById(id).isPresent()) {
            ordenCompraService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}