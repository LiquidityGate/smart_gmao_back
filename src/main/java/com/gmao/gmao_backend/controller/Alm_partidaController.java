package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_partidaDTO;
import com.gmao.gmao_backend.service.Alm_partidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_partidas")
public class Alm_partidaController {

    private final Alm_partidaService alm_partidaService;

    public Alm_partidaController(Alm_partidaService alm_partidaService) {
        this.alm_partidaService = alm_partidaService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_partidaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_partidaDTO filtros) {
        Page<Alm_partidaDTO> dtoPage = alm_partidaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_partidaDTO> getById(@PathVariable Long id) {
        return alm_partidaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_partidaDTO> create(@RequestBody Alm_partidaDTO alm_partidaDTO) {
        Alm_partidaDTO savedAlm_partida = alm_partidaService.save(alm_partidaDTO);
        return ResponseEntity.ok(savedAlm_partida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_partidaDTO> update(@PathVariable Long id, @RequestBody Alm_partidaDTO alm_partidaDTO) {
        alm_partidaDTO.setId(id);
        return alm_partidaService.findById(id)
                .map(existingAlm_partida -> {
                    Alm_partidaDTO updatedAlm_partida = alm_partidaService.update(id, alm_partidaDTO);
                    return ResponseEntity.ok(updatedAlm_partida);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_partidaService.findById(id).isPresent()) {
            alm_partidaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}