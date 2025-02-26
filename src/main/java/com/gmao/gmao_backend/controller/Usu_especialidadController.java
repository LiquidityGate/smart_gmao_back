package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_especialidadDTO;
import com.gmao.gmao_backend.service.Usu_especialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_especialidades")
public class Usu_especialidadController {

    private final Usu_especialidadService usu_especialidadService;

    public Usu_especialidadController(Usu_especialidadService usu_especialidadService) {
        this.usu_especialidadService = usu_especialidadService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_especialidadDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_especialidadDTO filtros) {
        Page<Usu_especialidadDTO> dtoPage = usu_especialidadService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_especialidadDTO> getById(@PathVariable Long id) {
        return usu_especialidadService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_especialidadDTO> create(@RequestBody Usu_especialidadDTO usu_especialidadDTO) {
        Usu_especialidadDTO savedUsu_especialidad = usu_especialidadService.save(usu_especialidadDTO);
        return ResponseEntity.ok(savedUsu_especialidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_especialidadDTO> update(@PathVariable Long id, @RequestBody Usu_especialidadDTO usu_especialidadDTO) {
        usu_especialidadDTO.setId(id);
        return usu_especialidadService.findById(id)
                .map(existingUsu_especialidad -> {
                    Usu_especialidadDTO updatedUsu_especialidad = usu_especialidadService.update(id, usu_especialidadDTO);
                    return ResponseEntity.ok(updatedUsu_especialidad);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_especialidadService.findById(id).isPresent()) {
            usu_especialidadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}