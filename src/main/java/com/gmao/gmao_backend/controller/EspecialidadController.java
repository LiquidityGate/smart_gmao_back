package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.EspecialidadDTO;
import com.gmao.gmao_backend.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    // Obtener todas las especialidades con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<EspecialidadDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        EspecialidadDTO filtros) {
        Page<EspecialidadDTO> dtoPage = especialidadService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }

    // Obtener todas las especialidades sin paginación
    @GetMapping("/all")
    public ResponseEntity<List<EspecialidadDTO>> getAllWithoutPagination(EspecialidadDTO filtros) {
        List<EspecialidadDTO> dtoList = especialidadService.findAllWithoutPagination(filtros);
        return ResponseEntity.ok(dtoList);
    }

    // Obtener todas las especialidades para un combobox
    @GetMapping("/combo")
    public ResponseEntity<List<EspecialidadDTO>> getEspecialidadesForCombo() {
        List<EspecialidadDTO> especialidades = especialidadService.findAllForCombo();
        return ResponseEntity.ok(especialidades);
    }

    // Obtener una especialidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> getById(@PathVariable Long id) {
        return especialidadService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva especialidad
    @PostMapping
    public ResponseEntity<EspecialidadDTO> create(@RequestBody EspecialidadDTO especialidadDTO) {
        EspecialidadDTO savedEspecialidad = especialidadService.save(especialidadDTO);
        return ResponseEntity.ok(savedEspecialidad);
    }

    // Actualizar una especialidad existente
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> update(@PathVariable Long id, @RequestBody EspecialidadDTO especialidadDTO) {
        especialidadDTO.setId(id); // Asegura que el ID en el DTO sea correcto para la actualización
        return especialidadService.findById(id)
                .map(existingEspecialidad -> {
                    EspecialidadDTO updatedEspecialidad = especialidadService.update(id, especialidadDTO);
                    return ResponseEntity.ok(updatedEspecialidad);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una especialidad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (especialidadService.findById(id).isPresent()) {
            especialidadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}