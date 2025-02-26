package com.gmao.gmao_backend.controller.AdministracionUsuarios.Configuracion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosTablaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosVistaDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.security.CustomUserDetails;
import com.gmao.gmao_backend.service.UsuarioService;
import com.gmao.gmao_backend.service.AdministracionUsuarios.Configuracion.MantenimientoCargosService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/administracion-usuarios/configuracion/mantenimiento-cargos")
public class MantenimientoCargosController {

    private final UsuarioService usuarioService;

    private final MantenimientoCargosService mantenimientoCargosService;

    public MantenimientoCargosController(UsuarioService usuarioService,
            MantenimientoCargosService mantenimientoCargosService) {
        this.usuarioService = usuarioService;
        this.mantenimientoCargosService = mantenimientoCargosService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<MantenimientoCargosTablaDTO>> verRegistros(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            MantenimientoCargosTablaDTO filtros) {

        return mantenimientoCargosService.verRegistros(page,
                size,
                sortField,
                sortDirection, filtros);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> insertarRegistro(
            @RequestBody MantenimientoCargosTablaDTO dto,
            Principal principal)
            throws JsonProcessingException {

        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioLog = usuarioService.getUsuarioPorId(customUserDetails.getId());

        return mantenimientoCargosService.insertarRegistro(usuarioLog, dto);

    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> actualizarRegistro(
            @RequestBody MantenimientoCargosTablaDTO dto, Principal principal)
            throws JsonProcessingException {
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioLog = usuarioService.getUsuarioPorId(customUserDetails.getId());

        return mantenimientoCargosService.actualizarRegistro(usuarioLog, dto);
    }

    @DeleteMapping("/{idRegistro}")
    public ResponseEntity<Map<String, Object>> eliminarRegistro(
            @PathVariable Long idRegistro, Principal principal)
            throws JsonProcessingException {
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioLog = usuarioService.getUsuarioPorId(customUserDetails.getId());

        return mantenimientoCargosService.eliminarRegistro(usuarioLog, idRegistro);
    }

    @GetMapping("/{idRegistro}")
    public ResponseEntity<List<MantenimientoCargosVistaDTO>> verRegistroPorID(
            @PathVariable Long idRegistro) {
        return mantenimientoCargosService.verRegistroPorID(idRegistro);
    }

}