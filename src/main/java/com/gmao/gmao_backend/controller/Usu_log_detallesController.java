package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Usu_log_detallesDTO;
import com.gmao.gmao_backend.service.Usu_log_detallesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/usu_log_detalles")
@CrossOrigin(origins = "*")
public class Usu_log_detallesController {

    private static final Logger logger = LoggerFactory.getLogger(Usu_log_detallesController.class);
    private final Usu_log_detallesService service;

    public Usu_log_detallesController(Usu_log_detallesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "creado_en") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection,
            @RequestParam(value = "creado_por", required = false) Long creado_por) {
        try {
            logger.info("Recibiendo solicitud para obtener logs con creado_por={}, page={}, size={}, sortField={}, sortDirection={}",
                    creado_por, page, size, sortField, sortDirection);

            Usu_log_detallesDTO filtros = new Usu_log_detallesDTO();
            if (creado_por != null) {
                filtros.setCreado_por(creado_por);
            }

            Page<Usu_log_detallesDTO> dtoPage = service.findAll(page, size, sortField, sortDirection.toUpperCase(), filtros);
            return ResponseEntity.ok(dtoPage);
        } catch (Exception e) {
            logger.error("Error al obtener logs: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usu_log_detallesDTO> getById(@PathVariable Long id) {
        try {
            logger.info("Buscando logs para id={}", id);
            Optional<Usu_log_detallesDTO> result = service.findById(id);
            if (result.isPresent()) {
                return ResponseEntity.ok(result.get());
            } else {
                logger.warn("No se encontró log para id={}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error al buscar logs por id={}: {}", id, e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }
}
