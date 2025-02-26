package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_logDTO;
import com.gmao.gmao_backend.service.Usu_logService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_log")
public class Usu_logController {

    private final Usu_logService usu_logService;

    public Usu_logController(Usu_logService usu_logService) {
        this.usu_logService = usu_logService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_logDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_logDTO filtros) {
        Page<Usu_logDTO> dtoPage = usu_logService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_logDTO> getById(@PathVariable Long id) {
        return usu_logService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_logDTO> create(@RequestBody Usu_logDTO usu_logDTO) {
        Usu_logDTO savedUsu_log = usu_logService.save(usu_logDTO);
        return ResponseEntity.ok(savedUsu_log);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_logDTO> update(@PathVariable Long id, @RequestBody Usu_logDTO usu_logDTO) {
        usu_logDTO.setId(id);
        return usu_logService.findById(id)
                .map(existingUsu_log -> {
                    Usu_logDTO updatedUsu_log = usu_logService.update(id, usu_logDTO);
                    return ResponseEntity.ok(updatedUsu_log);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_logService.findById(id).isPresent()) {
            usu_logService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}