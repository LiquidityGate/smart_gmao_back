package com.gmao.gmao_backend.controller.O.T;

import com.gmao.gmao_backend.dto.O.T.OrdenTrabajoPreventivaLegalDTO;
import com.gmao.gmao_backend.service.O.T.OrdenTrabajoPreventivaLegalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-trabajo-preventivas")
@RequiredArgsConstructor
@Tag(name = "Órdenes de Trabajo Preventivas Legal", description = "API para gestionar órdenes de trabajo de tipo preventivas legales")
public class OrdenTrabajoPreventivaLegalController {

    private final OrdenTrabajoPreventivaLegalService service;

    @GetMapping
    @Operation(summary = "Obtener todas las órdenes de trabajo preventivas legal")
   // @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<OrdenTrabajoPreventivaLegalDTO.Response>> getAllOrdenes() {
        return ResponseEntity.ok(service.getAllOrdenes());
    }

    /*@GetMapping("/{id}")
    @Operation(summary = "Obtener una orden de trabajo por su ID")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<OrdenTrabajoPreventivaLegalDTO.Response> getOrdenById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrdenById(id));
    }

    @GetMapping("/periodo/{periodo}")
    @Operation(summary = "Obtener una orden de trabajo por su periodo")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<OrdenTrabajoPreventivaLegalDTO.Response> getOrdenByPeriodo(@PathVariable String periodo) {
        return ResponseEntity.ok(service.getOrdenByPeriodo(periodo));
    }

    @PostMapping("/inicializar-demo")
    @Operation(summary = "Inicializar datos de demostración")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> inicializarDatos() {
        service.inicializarDatosDemo();
        return ResponseEntity.ok("Datos de demostración inicializados correctamente");
    }

    */
}
