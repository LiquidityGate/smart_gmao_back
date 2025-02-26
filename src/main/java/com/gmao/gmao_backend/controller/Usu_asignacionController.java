package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_asignacionDTO;
import com.gmao.gmao_backend.service.Usu_asignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_asignaciones")
public class Usu_asignacionController {

    private final Usu_asignacionService usu_asignacionService;

    public Usu_asignacionController(Usu_asignacionService usu_asignacionService) {
        this.usu_asignacionService = usu_asignacionService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_asignacionDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_asignacionDTO filtros) {
        Page<Usu_asignacionDTO> dtoPage = usu_asignacionService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_asignacionDTO> getById(@PathVariable Long id) {
        return usu_asignacionService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_asignacionDTO> create(@RequestBody Usu_asignacionDTO usu_asignacionDTO) {
        Usu_asignacionDTO savedUsu_asignacion = usu_asignacionService.save(usu_asignacionDTO);
        return ResponseEntity.ok(savedUsu_asignacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_asignacionDTO> update(@PathVariable Long id, @RequestBody Usu_asignacionDTO usu_asignacionDTO) {
        usu_asignacionDTO.setId(id);
        return usu_asignacionService.findById(id)
                .map(existingUsu_asignacion -> {
                    Usu_asignacionDTO updatedUsu_asignacion = usu_asignacionService.update(id, usu_asignacionDTO);
                    return ResponseEntity.ok(updatedUsu_asignacion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_asignacionService.findById(id).isPresent()) {
            usu_asignacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}