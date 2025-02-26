package com.gmao.gmao_backend.controller.AdministracionUsuarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaDietaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaLaboralDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaUsuarioDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosTablaDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.security.CustomUserDetails;
import com.gmao.gmao_backend.service.MantenimientoUsuariosService;
import com.gmao.gmao_backend.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/mantenimiento-usuarios")
public class MantenimientoUsuariosController {

    private final MantenimientoUsuariosService mantenimientoUsuariosService;
    private final UsuarioService usuarioService;

    public MantenimientoUsuariosController(
            MantenimientoUsuariosService mantenimientoUsuariosService, UsuarioService usuarioService) {
        this.mantenimientoUsuariosService = mantenimientoUsuariosService;
        this.usuarioService = usuarioService;
    }

    // Obtener todas las órdenes de trabajo con filtros
    @GetMapping
    public ResponseEntity<Page<MantenimientoUsuariosTablaDTO>> findTabla(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            MantenimientoUsuariosTablaDTO filtros) {

        return mantenimientoUsuariosService.findTabla(page,
                size,
                sortField,
                sortDirection, filtros);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> insertarRegistro(
            @RequestBody MantenimientoUsuariosTablaDTO dto,
            Principal principal)
            throws JsonProcessingException {

        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioLog = usuarioService.getUsuarioPorId(customUserDetails.getId());

        return mantenimientoUsuariosService.insertarRegistro(usuarioLog, dto);
    }

    @DeleteMapping("/{idRegistro}")
    public ResponseEntity<Map<String, Object>> eliminarRegistro(
            @PathVariable Long idRegistro, Principal principal)
            throws JsonProcessingException {
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioLog = usuarioService.getUsuarioPorId(customUserDetails.getId());

        return mantenimientoUsuariosService.eliminarRegistro(usuarioLog, idRegistro);
    }

    // -------------------------------------------------------------------
    // Ficha Usuario
    @GetMapping("/ficha-usuario/{usuarioId}")
    public ResponseEntity<List<MantenimientoUsuariosFichaUsuarioDTO>> getFichaUsuario(
            @PathVariable Long usuarioId) {
        return ResponseEntity.ok(mantenimientoUsuariosService.findFichaUsuario(usuarioId));
    }

    @PutMapping("/ficha-usuario")
    public ResponseEntity<Map<String, Object>> actualizarFichaUsuario(
            @RequestBody MantenimientoUsuariosFichaUsuarioDTO dto, Principal principal)
            throws JsonProcessingException {
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioLog = usuarioService.getUsuarioPorId(customUserDetails.getId());

        return mantenimientoUsuariosService.actualizarFichaUsuario(usuarioLog, dto);
    }

    // -------------------------------------------------------------------
    // Ficha Laboral
    @GetMapping("/ficha-laboral/{usuarioId}")
    public ResponseEntity<List<MantenimientoUsuariosFichaLaboralDTO>> getFichaLaboral(
            @PathVariable Long usuarioId) {
        return ResponseEntity.ok(mantenimientoUsuariosService.findFichaLaboral(usuarioId));
    }

    @PutMapping("/ficha-laboral")
    public ResponseEntity<Map<String, Object>> updateFichaLaboral(
            @RequestPart("dto") MantenimientoUsuariosFichaLaboralDTO dto,
            @RequestPart(value = "archivoFoto", required = false) MultipartFile archivoFoto, Principal principal)
            throws JsonProcessingException {
        Usuario usuarioLog = usuarioService.getUsuario(principal.getName());

        return mantenimientoUsuariosService.actualizarFichaLaboral(usuarioLog, dto, archivoFoto);
    }

    // -------------------------------------------------------------------
    // Ficha Dieta
    @GetMapping("/ficha-dieta/{usuarioId}")
    public ResponseEntity<Page<MantenimientoUsuariosFichaDietaDTO>> getFichaDieta(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @PathVariable Long usuarioId) {
        return ResponseEntity.ok(mantenimientoUsuariosService.findFichaDieta(page,
                size,
                sortField,
                sortDirection, usuarioId));
    }

    @PostMapping("/ficha-dieta")
    public ResponseEntity<MantenimientoUsuariosFichaDietaDTO> insertFichaDieta(
            @RequestBody MantenimientoUsuariosFichaDietaDTO dto, Principal principal)
            throws JsonProcessingException {
        Usuario usuarioLog = usuarioService.getUsuario(principal.getName());

        mantenimientoUsuariosService.insertFichaDieta(usuarioLog, dto);

        return ResponseEntity.ok(dto);
    }

    // -------------------------------------------------------------------
}