package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_turnoDTO;
import com.gmao.gmao_backend.service.Usu_turnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_turnos")
public class Usu_turnoController {

    private final Usu_turnoService usu_turnoService;

    public Usu_turnoController(Usu_turnoService usu_turnoService) {
        this.usu_turnoService = usu_turnoService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_turnoDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_turnoDTO filtros) {
        Page<Usu_turnoDTO> dtoPage = usu_turnoService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_turnoDTO> getById(@PathVariable Long id) {
        return usu_turnoService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_turnoDTO> create(@RequestBody Usu_turnoDTO usu_turnoDTO) {
        Usu_turnoDTO savedUsu_turno = usu_turnoService.save(usu_turnoDTO);
        return ResponseEntity.ok(savedUsu_turno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_turnoDTO> update(@PathVariable Long id, @RequestBody Usu_turnoDTO usu_turnoDTO) {
        usu_turnoDTO.setId(id);
        return usu_turnoService.findById(id)
                .map(existingUsu_turno -> {
                    Usu_turnoDTO updatedUsu_turno = usu_turnoService.update(id, usu_turnoDTO);
                    return ResponseEntity.ok(updatedUsu_turno);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_turnoService.findById(id).isPresent()) {
            usu_turnoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}