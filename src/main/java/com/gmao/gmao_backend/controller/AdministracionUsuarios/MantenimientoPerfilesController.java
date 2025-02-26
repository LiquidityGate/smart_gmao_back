package com.gmao.gmao_backend.controller.AdministracionUsuarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesMenusAccesosDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesMenusDTO;
import com.gmao.gmao_backend.model.AccesoXPerfil;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.service.LogMovimientoService;
import com.gmao.gmao_backend.service.MantenimientoPerfilesService;
import com.gmao.gmao_backend.service.UsrPerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gmao.gmao_backend.service.UsuarioService;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/mantenimiento-perfiles")
public class MantenimientoPerfilesController {

        private final UsrPerfilService usrPerfilService;
        private final UsuarioService usuarioService;
        private final MantenimientoPerfilesService mantenimientoPerfilesService;

        private final LogMovimientoService logMovimientoService;

        public MantenimientoPerfilesController(UsrPerfilService usrPerfilService, UsuarioService usuarioService,
                        LogMovimientoService logMovimientoService,
                        MantenimientoPerfilesService mantenimientoPerfilesService) {
                this.usrPerfilService = usrPerfilService;
                this.usuarioService = usuarioService;
                this.logMovimientoService = logMovimientoService;
                this.mantenimientoPerfilesService = mantenimientoPerfilesService;
        }

        // Obtener todas las órdenes de trabajo con filtros
        @GetMapping
        public ResponseEntity<Page<MantenimientoPerfilesDTO>> getAll(
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortField", defaultValue = "id") String sortField,
                        @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
                        MantenimientoPerfilesDTO filtros) {
                Page<MantenimientoPerfilesDTO> dtoPage = usrPerfilService.findAll(page, size, sortField, sortDirection,
                                filtros);
                return ResponseEntity.ok(dtoPage);
        }

        // Obtener una orden de trabajo por ID
        @GetMapping("/{id}")
        public ResponseEntity<MantenimientoPerfilesDTO> getById(@PathVariable Long id) {
                return usrPerfilService.findById(id).map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Crear una nueva orden de trabajo
        @PostMapping
        public ResponseEntity<MantenimientoPerfilesDTO> create(@RequestBody MantenimientoPerfilesDTO usrPerfilDTO,
                        Principal principal) throws JsonProcessingException {

                Long usuarioId = usuarioService.getUsuario(principal.getName()).getId();
                usrPerfilDTO.setCreadoPorId(usuarioId);

                MantenimientoPerfilesDTO savedDTO = usrPerfilService.save(usrPerfilDTO);

                String msj_log = "ha creado el perfil " + savedDTO.getNombre();
                logMovimientoService.registrarLog("INSERT", "tbl_perfiles", savedDTO.getId(), null, savedDTO, usuarioId,
                                msj_log);

                return ResponseEntity.ok(savedDTO);
        }

        // Actualizar una orden de trabajo existente
        @PutMapping("/{id}")
        public ResponseEntity<MantenimientoPerfilesDTO> update(@PathVariable Long id,
                        @RequestBody MantenimientoPerfilesDTO usrPerfilDTO, Principal principal)
                        throws JsonProcessingException {
                Usuario usuarioP = usuarioService.getUsuario(principal.getName());

                usrPerfilDTO.setActualizadoPorId(usuarioP.getId());
                usrPerfilDTO.setActualizadoPorNombre(usuarioP.getNombres());
                usrPerfilDTO.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                usrPerfilDTO.setId(id);

                // Llamar al servicio de actualización, que ahora devuelve un Map
                Map<String, Object> updateResult = usrPerfilService.update(id, usrPerfilDTO);

                // Obtener los valores de la respuesta
                MantenimientoPerfilesDTO updatedDTO = (MantenimientoPerfilesDTO) updateResult.get("updatedDTO");
                MantenimientoPerfilesDTO existingDTO = (MantenimientoPerfilesDTO) updateResult.get("existingDTO");

                // Crear y guardar el log
                String msj_log = "ha actualizado el perfil " + updatedDTO.getNombre();
                logMovimientoService.registrarLog("UPDATE", "tbl_perfiles", updatedDTO.getId(), existingDTO, updatedDTO,
                                usuarioP.getId(), msj_log);
                return ResponseEntity.ok(updatedDTO);
        }

        // Obtener usuarios para el select box
        @GetMapping("/select")
        public ResponseEntity<List<MantenimientoPerfilesDTO>> getUsuariosForSelect() {
                List<MantenimientoPerfilesDTO> usuarios = usrPerfilService.findAllForSelect();
                return ResponseEntity.ok(usuarios);
        }

        // Datos x Perfil
        @GetMapping("/datosPerfil/{perfilId}")
        public ResponseEntity<List<MantenimientoPerfilesDTO>> getDatosPerfil(
                        @PathVariable Long perfilId) {
                return ResponseEntity.ok(mantenimientoPerfilesService.findDatosPerfil(perfilId));
        }

        // Menus x Perfil
        @GetMapping("/menus/{perfilId}")
        public ResponseEntity<List<MantenimientoPerfilesMenusDTO>> getMenu(
                        @PathVariable Long perfilId) {
                return ResponseEntity.ok(mantenimientoPerfilesService.findMenusByPerfil(perfilId));
        }

        // Crear MenuxPerfil
        @PostMapping("/menus")
        public ResponseEntity<MantenimientoPerfilesMenusAccesosDTO> createAccesoMenu(
                        @RequestBody MantenimientoPerfilesMenusAccesosDTO dto,
                        Principal principal) throws JsonProcessingException {

                Long usuarioId = usuarioService.getUsuario(principal.getName()).getId();
                dto.setCreadoPorId(usuarioId);
                dto.setCreadoEn(new Timestamp(System.currentTimeMillis()));

                MantenimientoPerfilesMenusAccesosDTO savedDTO = mantenimientoPerfilesService.saveMenus(dto);

                String msj_log = "ha creado el acceso a " + dto.getNombreMenu() + " para el perfil "
                                + dto.getNombrePerfil();
                logMovimientoService.registrarLog("INSERT", "tbl_accesos_xperfil", savedDTO.getId(), null, savedDTO,
                                usuarioId,
                                msj_log);

                return ResponseEntity.ok(savedDTO);
        }

        // Actualizar acceso al menu
        @PutMapping("/menus/{idMenuAcceso}")
        public ResponseEntity<MantenimientoPerfilesMenusAccesosDTO> updateAccesoMenu(@PathVariable Long idMenuAcceso,
                        @RequestBody MantenimientoPerfilesMenusAccesosDTO dto,
                        Principal principal) throws JsonProcessingException {
                Usuario usuarioP = usuarioService.getUsuario(principal.getName());

                dto.setActualizadoPorId(usuarioP.getId());
                dto.setActualizadoPorNombre(usuarioP.getNombres());
                dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                dto.setId(idMenuAcceso);

                // Llamar al servicio de actualización, que ahora devuelve un Map
                Map<String, Object> updateResult = mantenimientoPerfilesService.updateByIdMenu(idMenuAcceso, dto);

                // Obtener los valores de la respuesta
                MantenimientoPerfilesMenusAccesosDTO updatedDTO = (MantenimientoPerfilesMenusAccesosDTO) updateResult
                                .get("updatedDTO");
                MantenimientoPerfilesMenusAccesosDTO existingDTO = (MantenimientoPerfilesMenusAccesosDTO) updateResult
                                .get("existingDTO");

                // Crear y guardar el log
                String msj_log = "ha actualizado el acceso a " + updatedDTO.getNombreMenu() + " del perfil "
                                + updatedDTO.getNombrePerfil();
                logMovimientoService.registrarLog("UPDATE", "tbl_accesos_xperfil", updatedDTO.getId(), existingDTO,
                                updatedDTO,
                                usuarioP.getId(), msj_log);
                return ResponseEntity.ok(updatedDTO);
        }

        // Eliminar acceso al menu
        @DeleteMapping("/menus/{idMenuAcceso}")
        public ResponseEntity<Void> deleteAccesoMenu(
                        Principal principal, @PathVariable Long idMenuAcceso) throws JsonProcessingException {
                Long usuarioId = usuarioService.getUsuario(principal.getName()).getId();

                Optional<AccesoXPerfil> entidadOptional = mantenimientoPerfilesService.findByIdMenu(idMenuAcceso);
                if (entidadOptional.isPresent()) {
                        mantenimientoPerfilesService.deleteByIdMenu(idMenuAcceso);

                        AccesoXPerfil entidad = entidadOptional.get();
                        String msj_log = "ha eliminado el acceso a " + entidad.getIdMenu() + " para el perfil "
                                        + entidad.getIdPerfil();

                        logMovimientoService.registrarLog("DELETE", "tbl_accesos_xperfil", entidad.getId(), entidad,
                                        null,
                                        usuarioId,
                                        msj_log);
                        return ResponseEntity.noContent().build();
                } else {
                        return ResponseEntity.notFound().build();
                }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<MantenimientoPerfilesDTO> deleteTipoAsignacion(@PathVariable Long id,
                        Principal principal)
                        throws JsonProcessingException {
                Usuario usuarioP = usuarioService.getUsuario(principal.getName());

                MantenimientoPerfilesDTO dto = new MantenimientoPerfilesDTO();
                dto.setActualizadoPorId(usuarioP.getId());
                dto.setActualizadoPorNombre(usuarioP.getNombres());
                dto.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                dto.setId(id);
                dto.setEstadoEliminado(true);

                // Llamar al servicio de actualización, que ahora devuelve un Map
                Map<String, Object> updateResult = mantenimientoPerfilesService.updateById(id, dto);

                // Obtener los valores de la respuesta
                MantenimientoPerfilesDTO updatedDTO = (MantenimientoPerfilesDTO) updateResult.get("updatedDTO");
                MantenimientoPerfilesDTO existingDTO = (MantenimientoPerfilesDTO) updateResult
                                .get("existingDTO");

                // Crear y guardar el log
                String msj_log = usuarioP.getUsuario() + " ha eliminado el perfil " + existingDTO.getNombre();
                logMovimientoService.registrarLog("DELETE", "usuarios_perfiles", updatedDTO.getId(), existingDTO,
                                updatedDTO,
                                usuarioP.getId(), msj_log);
                return ResponseEntity.ok(updatedDTO);

        }

}