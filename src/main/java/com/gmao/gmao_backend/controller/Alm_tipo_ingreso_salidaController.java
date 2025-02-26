package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Alm_tipo_ingreso_salidaDTO;
import com.gmao.gmao_backend.service.Alm_tipo_ingreso_salidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/alm_tipo_ingreso_salidas")
public class Alm_tipo_ingreso_salidaController {

    private final Alm_tipo_ingreso_salidaService alm_tipo_ingreso_salidaService;

    public Alm_tipo_ingreso_salidaController(Alm_tipo_ingreso_salidaService alm_tipo_ingreso_salidaService) {
        this.alm_tipo_ingreso_salidaService = alm_tipo_ingreso_salidaService;
    }

    @GetMapping
    public ResponseEntity<Page<Alm_tipo_ingreso_salidaDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Alm_tipo_ingreso_salidaDTO filtros) {
        Page<Alm_tipo_ingreso_salidaDTO> dtoPage = alm_tipo_ingreso_salidaService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alm_tipo_ingreso_salidaDTO> getById(@PathVariable Long id) {
        return alm_tipo_ingreso_salidaService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alm_tipo_ingreso_salidaDTO> create(@RequestBody Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO) {
        Alm_tipo_ingreso_salidaDTO savedAlm_tipo_ingreso_salida = alm_tipo_ingreso_salidaService.save(alm_tipo_ingreso_salidaDTO);
        return ResponseEntity.ok(savedAlm_tipo_ingreso_salida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alm_tipo_ingreso_salidaDTO> update(@PathVariable Long id, @RequestBody Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO) {
        alm_tipo_ingreso_salidaDTO.setId(id);
        return alm_tipo_ingreso_salidaService.findById(id)
                .map(existingAlm_tipo_ingreso_salida -> {
                    Alm_tipo_ingreso_salidaDTO updatedAlm_tipo_ingreso_salida = alm_tipo_ingreso_salidaService.update(id, alm_tipo_ingreso_salidaDTO);
                    return ResponseEntity.ok(updatedAlm_tipo_ingreso_salida);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alm_tipo_ingreso_salidaService.findById(id).isPresent()) {
            alm_tipo_ingreso_salidaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}