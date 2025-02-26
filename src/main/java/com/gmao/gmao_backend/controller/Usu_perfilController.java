package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_perfilDTO;
import com.gmao.gmao_backend.service.Usu_perfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_perfiles")
public class Usu_perfilController {

    private final Usu_perfilService usu_perfilService;

    public Usu_perfilController(Usu_perfilService usu_perfilService) {
        this.usu_perfilService = usu_perfilService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_perfilDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_perfilDTO filtros) {
        Page<Usu_perfilDTO> dtoPage = usu_perfilService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_perfilDTO> getById(@PathVariable Long id) {
        return usu_perfilService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_perfilDTO> create(@RequestBody Usu_perfilDTO usu_perfilDTO) {
        Usu_perfilDTO savedUsu_perfil = usu_perfilService.save(usu_perfilDTO);
        return ResponseEntity.ok(savedUsu_perfil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_perfilDTO> update(@PathVariable Long id, @RequestBody Usu_perfilDTO usu_perfilDTO) {
        usu_perfilDTO.setId(id);
        return usu_perfilService.findById(id)
                .map(existingUsu_perfil -> {
                    Usu_perfilDTO updatedUsu_perfil = usu_perfilService.update(id, usu_perfilDTO);
                    return ResponseEntity.ok(updatedUsu_perfil);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_perfilService.findById(id).isPresent()) {
            usu_perfilService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}