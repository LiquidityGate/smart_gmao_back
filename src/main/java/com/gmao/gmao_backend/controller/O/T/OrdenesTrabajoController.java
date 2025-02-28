package com.gmao.gmao_backend.controller.O.T;

import com.gmao.gmao_backend.dto.O.T.OrdenesTrabajoDTO;
import com.gmao.gmao_backend.service.O.T.OrdenesTrabajoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reporte-ordenes-trabajo")
@RequiredArgsConstructor
@Tag(name = "Órdenes de Trabajo", description = "API para gestionar órdenes de trabajo de diferentes tipos")
public class OrdenesTrabajoController {
    private final OrdenesTrabajoService service;

    @GetMapping("/tipos")
    @Operation(summary = "Obtener todos los tipos de órdenes de trabajo disponibles")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<OrdenesTrabajoDTO.TipoDTO>> getTiposOrdenesTrabajo() {
        return ResponseEntity.ok(service.getTiposOrdenesTrabajo());
    }

    @GetMapping
    @Operation(summary = "Obtener todas las órdenes de trabajo")
    public ResponseEntity<List<OrdenesTrabajoDTO.Response>> getAllOrdenes() {
        return ResponseEntity.ok(service.getAllOrdenes());
    }
    @GetMapping("/tipo/{tipo}")
    @Operation(summary = "Obtener todas las órdenes de trabajo de un tipo específico")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<OrdenesTrabajoDTO.Response>> getOrdenesByTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(service.getOrdenesByTipo(tipo));
    }

}