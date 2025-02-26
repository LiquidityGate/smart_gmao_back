package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_privilegioDTO;
import com.gmao.gmao_backend.service.Usu_privilegioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_privilegios")
public class Usu_privilegioController {

    private final Usu_privilegioService usu_privilegioService;

    public Usu_privilegioController(Usu_privilegioService usu_privilegioService) {
        this.usu_privilegioService = usu_privilegioService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_privilegioDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_privilegioDTO filtros) {
        Page<Usu_privilegioDTO> dtoPage = usu_privilegioService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_privilegioDTO> getById(@PathVariable Long id) {
        return usu_privilegioService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_privilegioDTO> create(@RequestBody Usu_privilegioDTO usu_privilegioDTO) {
        Usu_privilegioDTO savedUsu_privilegio = usu_privilegioService.save(usu_privilegioDTO);
        return ResponseEntity.ok(savedUsu_privilegio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_privilegioDTO> update(@PathVariable Long id, @RequestBody Usu_privilegioDTO usu_privilegioDTO) {
        usu_privilegioDTO.setId(id);
        return usu_privilegioService.findById(id)
                .map(existingUsu_privilegio -> {
                    Usu_privilegioDTO updatedUsu_privilegio = usu_privilegioService.update(id, usu_privilegioDTO);
                    return ResponseEntity.ok(updatedUsu_privilegio);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_privilegioService.findById(id).isPresent()) {
            usu_privilegioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}