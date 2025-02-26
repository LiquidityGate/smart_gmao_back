package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_ent_salDTO;
import com.gmao.gmao_backend.service.Alm_ent_salService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_ent_sals")
public class Alm_ent_salController {

    private final Alm_ent_salService alm_ent_salService;

    public Alm_ent_salController(Alm_ent_salService alm_ent_salService) {
        this.alm_ent_salService = alm_ent_salService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_ent_salDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_ent_salDTO filtros) {
        Page<Alm_ent_salDTO> dtoPage = alm_ent_salService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_ent_salDTO> getById(@PathVariable Long id) {
        return alm_ent_salService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_ent_salDTO> create(@RequestBody Alm_ent_salDTO alm_ent_salDTO) {
        Alm_ent_salDTO savedAlm_ent_sal = alm_ent_salService.save(alm_ent_salDTO);
        return ResponseEntity.ok(savedAlm_ent_sal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_ent_salDTO> update(@PathVariable Long id, @RequestBody Alm_ent_salDTO alm_ent_salDTO) {
        alm_ent_salDTO.setId(id);
        return alm_ent_salService.findById(id)
                .map(existingAlm_ent_sal -> {
                    Alm_ent_salDTO updatedAlm_ent_sal = alm_ent_salService.update(id, alm_ent_salDTO);
                    return ResponseEntity.ok(updatedAlm_ent_sal);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_ent_salService.findById(id).isPresent()) {
            alm_ent_salService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}