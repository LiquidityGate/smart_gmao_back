package com.gmao.gmao_backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionActividadGestionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionCargoDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTipoAsignacionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTurnoDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.service.ConfiguracionService;
import com.gmao.gmao_backend.service.LogMovimientoService;
import com.gmao.gmao_backend.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Map;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/configuracion")
public class ConfiguracionController {

    private final ConfiguracionService configuracionService;
    private final UsuarioService usuarioService;
    private final LogMovimientoService logMovimientoService;

    public ConfiguracionController(ConfiguracionService configuracionService, UsuarioService usuarioService,
            LogMovimientoService logMovimientoService) {
        this.configuracionService = configuracionService;
        this.usuarioService = usuarioService;
        this.logMovimientoService = logMovimientoService;
    }

    // Cargo
    @GetMapping("/cargo")
    public ResponseEntity<Page<ConfiguracionCargoDTO>> getAllCargo(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            ConfiguracionCargoDTO filtros) {
        Page<ConfiguracionCargoDTO> dtoPage = configuracionService.findAllCargo(page, size, sortField, sortDirection,
                filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @PostMapping("/cargo")
    public ResponseEntity<ConfiguracionCargoDTO> createCargo(@RequestBody ConfiguracionCargoDTO dto,
            Principal principal) throws JsonProcessingException {

        Usuario usuario = usuarioService.getUsuario(principal.getName());
        dto.setCreadoPorId(usuario.getId());

        ConfiguracionCargoDTO savedDTO = configuracionService.saveCargo(dto);

        String msj_log = usuario.getUsuario() + " ha creado el cargo " + savedDTO.getNombre();
        logMovimientoService.registrarLog("INSERT", "cargos", savedDTO.getId(), null, savedDTO, usuario.getId(),
                msj_log);

        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/cargo/{id}")
    public ResponseEntity<ConfiguracionCargoDTO> updateCargo(@PathVariable Long id,
            @RequestBody ConfiguracionCargoDTO dto, Principal principal) throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdCargo(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionCargoDTO updatedDTO = (ConfiguracionCargoDTO) updateResult.get("updatedDTO");
        ConfiguracionCargoDTO existingDTO = (ConfiguracionCargoDTO) updateResult.get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha actualizado el cargo " + existingDTO.getNombre();
        logMovimientoService.registrarLog("UPDATE", "cargos", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/cargo/{id}")
    public ResponseEntity<ConfiguracionCargoDTO> deleteCargo(@PathVariable Long id, Principal principal)
            throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        ConfiguracionCargoDTO dto = new ConfiguracionCargoDTO();
        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);
        dto.setEstadoEliminado(true);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdCargo(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionCargoDTO updatedDTO = (ConfiguracionCargoDTO) updateResult.get("updatedDTO");
        ConfiguracionCargoDTO existingDTO = (ConfiguracionCargoDTO) updateResult.get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha eliminado el cargo " + existingDTO.getNombre();
        logMovimientoService.registrarLog("DELETE", "cargos", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }

    // -----------------------

    // Turno
    @GetMapping("/turno")
    public ResponseEntity<Page<ConfiguracionTurnoDTO>> getAllTurno(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            ConfiguracionTurnoDTO filtros) {
        Page<ConfiguracionTurnoDTO> dtoPage = configuracionService.findAllTurno(page, size, sortField, sortDirection,
                filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @PostMapping("/turno")
    public ResponseEntity<ConfiguracionTurnoDTO> createTurno(@RequestBody ConfiguracionTurnoDTO dto,
            Principal principal) throws JsonProcessingException {

        Usuario usuario = usuarioService.getUsuario(principal.getName());
        dto.setCreadoPorId(usuario.getId());

        ConfiguracionTurnoDTO savedDTO = configuracionService.saveTurno(dto);

        String msj_log = usuario.getUsuario() + " ha creado el turno " + savedDTO.getNombre();
        logMovimientoService.registrarLog("INSERT", "turnos", savedDTO.getId(), null, savedDTO, usuario.getId(),
                msj_log);

        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/turno/{id}")
    public ResponseEntity<ConfiguracionTurnoDTO> updateTurno(@PathVariable Long id,
            @RequestBody ConfiguracionTurnoDTO dto, Principal principal) throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdTurno(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionTurnoDTO updatedDTO = (ConfiguracionTurnoDTO) updateResult.get("updatedDTO");
        ConfiguracionTurnoDTO existingDTO = (ConfiguracionTurnoDTO) updateResult.get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha actualizado el turno " + existingDTO.getNombre();
        logMovimientoService.registrarLog("UPDATE", "turnos", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/turno/{id}")
    public ResponseEntity<ConfiguracionTurnoDTO> deleteTurno(@PathVariable Long id, Principal principal)
            throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        ConfiguracionTurnoDTO dto = new ConfiguracionTurnoDTO();
        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);
        dto.setEstadoEliminado(true);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdTurno(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionTurnoDTO updatedDTO = (ConfiguracionTurnoDTO) updateResult.get("updatedDTO");
        ConfiguracionTurnoDTO existingDTO = (ConfiguracionTurnoDTO) updateResult.get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha eliminado el turno " + existingDTO.getNombre();
        logMovimientoService.registrarLog("DELETE", "turnos", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }
    // ---------------------------------

    // Actividad Gestion
    @GetMapping("/actividad-gestion")
    public ResponseEntity<Page<ConfiguracionActividadGestionDTO>> getAllActividadGestion(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            ConfiguracionActividadGestionDTO filtros) {
        Page<ConfiguracionActividadGestionDTO> dtoPage = configuracionService.findAllActividadGestion(page, size,
                sortField, sortDirection,
                filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @PostMapping("/actividad-gestion")
    public ResponseEntity<ConfiguracionActividadGestionDTO> createActividadGestion(
            @RequestBody ConfiguracionActividadGestionDTO dto,
            Principal principal) throws JsonProcessingException {

        Usuario usuario = usuarioService.getUsuario(principal.getName());
        dto.setCreadoPorId(usuario.getId());

        ConfiguracionActividadGestionDTO savedDTO = configuracionService.saveActividadGestion(dto);

        String msj_log = usuario.getUsuario() + " ha creado la actividad de gestión " + savedDTO.getNombre();
        logMovimientoService.registrarLog("INSERT", "actividades_gestion", savedDTO.getId(), null, savedDTO,
                usuario.getId(),
                msj_log);

        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/actividad-gestion/{id}")
    public ResponseEntity<ConfiguracionActividadGestionDTO> updateActividadGestion(@PathVariable Long id,
            @RequestBody ConfiguracionActividadGestionDTO dto, Principal principal) throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdActividadGestion(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionActividadGestionDTO updatedDTO = (ConfiguracionActividadGestionDTO) updateResult.get("updatedDTO");
        ConfiguracionActividadGestionDTO existingDTO = (ConfiguracionActividadGestionDTO) updateResult
                .get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha actualizado la actividad de gestión " + existingDTO.getNombre();
        logMovimientoService.registrarLog("UPDATE", "actividades_gestion", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/actividad-gestion/{id}")
    public ResponseEntity<ConfiguracionActividadGestionDTO> deleteActividadGestion(@PathVariable Long id,
            Principal principal)
            throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        ConfiguracionActividadGestionDTO dto = new ConfiguracionActividadGestionDTO();
        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);
        dto.setEstadoEliminado(true);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdActividadGestion(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionActividadGestionDTO updatedDTO = (ConfiguracionActividadGestionDTO) updateResult.get("updatedDTO");
        ConfiguracionActividadGestionDTO existingDTO = (ConfiguracionActividadGestionDTO) updateResult
                .get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha eliminado la actividad de gestión " + existingDTO.getNombre();
        logMovimientoService.registrarLog("DELETE", "actividades_gestion", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }
    // ---------------------------------

    // Tipo Asignacion
    @GetMapping("/tipo-asignacion")
    public ResponseEntity<Page<ConfiguracionTipoAsignacionDTO>> getAllTipoAsignacion(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            ConfiguracionTipoAsignacionDTO filtros) {
        Page<ConfiguracionTipoAsignacionDTO> dtoPage = configuracionService.findAllTipoAsignacion(page, size, sortField,
                sortDirection,
                filtros);
        return ResponseEntity.ok(dtoPage);
    }

    @PostMapping("/tipo-asignacion")
    public ResponseEntity<ConfiguracionTipoAsignacionDTO> createTipoAsignacion(
            @RequestBody ConfiguracionTipoAsignacionDTO dto,
            Principal principal) throws JsonProcessingException {

        Usuario usuario = usuarioService.getUsuario(principal.getName());
        dto.setCreadoPorId(usuario.getId());

        ConfiguracionTipoAsignacionDTO savedDTO = configuracionService.saveTipoAsignacion(dto);

        String msj_log = usuario.getUsuario() + " ha creado el tipo de asignación " + savedDTO.getNombre();
        logMovimientoService.registrarLog("INSERT", "tipos_asignacion", savedDTO.getId(), null, savedDTO,
                usuario.getId(),
                msj_log);

        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/tipo-asignacion/{id}")
    public ResponseEntity<ConfiguracionTipoAsignacionDTO> updateTipoAsignacion(@PathVariable Long id,
            @RequestBody ConfiguracionTipoAsignacionDTO dto, Principal principal) throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdTipoAsignacion(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionTipoAsignacionDTO updatedDTO = (ConfiguracionTipoAsignacionDTO) updateResult.get("updatedDTO");
        ConfiguracionTipoAsignacionDTO existingDTO = (ConfiguracionTipoAsignacionDTO) updateResult.get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha actualizado el tipo de asignación " + existingDTO.getNombre();
        logMovimientoService.registrarLog("UPDATE", "tipos_asignacion", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/tipo-asignacion/{id}")
    public ResponseEntity<ConfiguracionActividadGestionDTO> deleteTipoAsignacion(@PathVariable Long id,
            Principal principal)
            throws JsonProcessingException {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());

        ConfiguracionActividadGestionDTO dto = new ConfiguracionActividadGestionDTO();
        dto.setActualizadoPorId(usuarioP.getId());
        dto.setActualizadoPorNombre(usuarioP.getNombres());
        dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
        dto.setId(id);
        dto.setEstadoEliminado(true);

        // Llamar al servicio de actualización, que ahora devuelve un Map
        Map<String, Object> updateResult = configuracionService.updateByIdActividadGestion(id, dto);

        // Obtener los valores de la respuesta
        ConfiguracionActividadGestionDTO updatedDTO = (ConfiguracionActividadGestionDTO) updateResult.get("updatedDTO");
        ConfiguracionActividadGestionDTO existingDTO = (ConfiguracionActividadGestionDTO) updateResult
                .get("existingDTO");

        // Crear y guardar el log
        String msj_log = usuarioP.getUsuario() + " ha eliminado el tipo de asignación " + existingDTO.getNombre();
        logMovimientoService.registrarLog("DELETE", "actividades_gestion", updatedDTO.getId(), existingDTO, updatedDTO,
                usuarioP.getId(), msj_log);
        return ResponseEntity.ok(updatedDTO);
    }
    // ---------------------------------

}