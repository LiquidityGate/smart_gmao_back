package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_cargoDTO;
import com.gmao.gmao_backend.service.Usu_cargoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_cargos")
public class Usu_cargoController {

    private final Usu_cargoService usu_cargoService;

    public Usu_cargoController(Usu_cargoService usu_cargoService) {
        this.usu_cargoService = usu_cargoService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_cargoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_cargoDTO filtros) {
        Page<Usu_cargoDTO> dtoPage = usu_cargoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_cargoDTO> getById(@PathVariable Long id) {
        return usu_cargoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_cargoDTO> create(@RequestBody Usu_cargoDTO usu_cargoDTO) {
        Usu_cargoDTO savedUsu_cargo = usu_cargoService.save(usu_cargoDTO);
        return ResponseEntity.ok(savedUsu_cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_cargoDTO> update(@PathVariable Long id, @RequestBody Usu_cargoDTO usu_cargoDTO) {
        usu_cargoDTO.setId(id);
        return usu_cargoService.findById(id)
                .map(existingUsu_cargo -> {
                    Usu_cargoDTO updatedUsu_cargo = usu_cargoService.update(id, usu_cargoDTO);
                    return ResponseEntity.ok(updatedUsu_cargo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_cargoService.findById(id).isPresent()) {
            usu_cargoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}