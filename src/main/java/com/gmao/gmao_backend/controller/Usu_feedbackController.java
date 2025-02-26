package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_feedbackDTO;
import com.gmao.gmao_backend.service.Usu_feedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/usu_feedback")
public class Usu_feedbackController {

    private final Usu_feedbackService usu_feedbackService;

    public Usu_feedbackController(Usu_feedbackService usu_feedbackService) {
        this.usu_feedbackService = usu_feedbackService;
    }

    @GetMapping
    public ResponseEntity<Page<Usu_feedbackDTO>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
        Usu_feedbackDTO filtros) {
        Page<Usu_feedbackDTO> dtoPage = usu_feedbackService.findAll(page, size, sortField, sortDirection, filtros);
        return ResponseEntity.ok(dtoPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usu_feedbackDTO> getById(@PathVariable Long id) {
        return usu_feedbackService.findById(id)
                                  .map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usu_feedbackDTO> create(@RequestBody Usu_feedbackDTO usu_feedbackDTO) {
        Usu_feedbackDTO savedUsu_feedback = usu_feedbackService.save(usu_feedbackDTO);
        return ResponseEntity.ok(savedUsu_feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usu_feedbackDTO> update(@PathVariable Long id, @RequestBody Usu_feedbackDTO usu_feedbackDTO) {
        usu_feedbackDTO.setId(id);
        return usu_feedbackService.findById(id)
                .map(existingUsu_feedback -> {
                    Usu_feedbackDTO updatedUsu_feedback = usu_feedbackService.update(id, usu_feedbackDTO);
                    return ResponseEntity.ok(updatedUsu_feedback);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usu_feedbackService.findById(id).isPresent()) {
            usu_feedbackService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}