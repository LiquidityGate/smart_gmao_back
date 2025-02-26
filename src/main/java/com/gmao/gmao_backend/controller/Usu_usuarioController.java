package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_usuarioDTO;
import com.gmao.gmao_backend.service.Usu_usuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_usuarios")
public class Usu_usuarioController {

    private final Usu_usuarioService usu_usuarioService;

    public Usu_usuarioController(Usu_usuarioService usu_usuarioService) {
        this.usu_usuarioService = usu_usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_usuarioDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_usuarioDTO filtros) {
        Page<Usu_usuarioDTO> dtoPage = usu_usuarioService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_usuarioDTO> getById(@PathVariable Long id) {
        return usu_usuarioService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_usuarioDTO> create(@RequestBody Usu_usuarioDTO usu_usuarioDTO) {
        Usu_usuarioDTO savedUsu_usuario = usu_usuarioService.save(usu_usuarioDTO);
        return ResponseEntity.ok(savedUsu_usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_usuarioDTO> update(@PathVariable Long id, @RequestBody Usu_usuarioDTO usu_usuarioDTO) {
        usu_usuarioDTO.setId(id);
        return usu_usuarioService.findById(id)
                .map(existingUsu_usuario -> {
                    Usu_usuarioDTO updatedUsu_usuario = usu_usuarioService.update(id, usu_usuarioDTO);
                    return ResponseEntity.ok(updatedUsu_usuario);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_usuarioService.findById(id).isPresent()) {
            usu_usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}