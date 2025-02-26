package com.gmao.gmao_backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaDietaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaLaboralDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaUsuarioDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosTablaDTO;
import com.gmao.gmao_backend.mapper.AdministracionUsuarios.MantenimientoUsuariosMapper;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.model.UsuarioDieta;
import com.gmao.gmao_backend.repository.UsuarioDietaRepository;
import com.gmao.gmao_backend.repository.AdministracionUsuarios.MantenimientoUsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class MantenimientoUsuariosService {
        @Autowired
        private PasswordEncoder passwordEncoder;

        private final MantenimientoUsuariosRepository mantenimientoUsuariosRepository;
        private final UsuarioDietaRepository usuarioDietaRepository;
        private final MantenimientoUsuariosMapper mantenimientoUsuariosMapper;
        private final LogMovimientoService logMovimientoService;
        private final UsuarioService usuarioService;
        private final FileService fileService;

        public MantenimientoUsuariosService(MantenimientoUsuariosRepository mantenimientoUsuariosRepository,
                        MantenimientoUsuariosMapper mantenimientoUsuariosMapper,
                        UsuarioDietaRepository usuarioDietaRepository,
                        LogMovimientoService logMovimientoService, UsuarioService usuarioService,
                        FileService fileService) {
                this.mantenimientoUsuariosRepository = mantenimientoUsuariosRepository;
                this.mantenimientoUsuariosMapper = mantenimientoUsuariosMapper;
                this.usuarioDietaRepository = usuarioDietaRepository;
                this.logMovimientoService = logMovimientoService;
                this.usuarioService = usuarioService;
                this.fileService = fileService;
        }

        // -------------------------------------------------------------------
        // Tabla principal
        public ResponseEntity<Page<MantenimientoUsuariosTablaDTO>> findTabla(int page, int size, String sortField,
                        String sortDirection, MantenimientoUsuariosTablaDTO filterDTO) {
                Pageable pageable;
                if ("valorSubtipo".equals(sortField)) {
                        pageable = PageRequest.of(page, size,
                                        Sort.by(Sort.Direction.fromString(sortDirection), "subtipo.nombre"));
                } else if ("valorIdentidad".equals(sortField)) {
                        pageable = PageRequest.of(page, size,
                                        Sort.by(Sort.Direction.fromString(sortDirection), "tipoIdentidad.nombre"));
                } else if ("valorPerfil".equals(sortField)) {
                        pageable = PageRequest.of(page, size,
                                        Sort.by(Sort.Direction.fromString(sortDirection), "perfil.nombre"));
                } else if ("valorCargo".equals(sortField)) {
                        pageable = PageRequest.of(page, size,
                                        Sort.by(Sort.Direction.fromString(sortDirection), "cargo.nombre"));
                } else if ("valorTurno".equals(sortField)) {
                        pageable = PageRequest.of(page, size,
                                        Sort.by(Sort.Direction.fromString(sortDirection), "turno.turno"));
                } else {
                        pageable = PageRequest.of(page, size,
                                        Sort.by(Sort.Direction.fromString(sortDirection), sortField));
                }

                Page<MantenimientoUsuariosTablaDTO> tabla = mantenimientoUsuariosRepository.findTabla(filterDTO,
                                pageable);
                return new ResponseEntity<>(tabla, HttpStatus.OK);
        }

        public ResponseEntity<Map<String, Object>> insertarRegistro(Usuario usuarioLog,
                        MantenimientoUsuariosTablaDTO savedDTO) throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Verifica si ya existe
                if (mantenimientoUsuariosRepository.findByUsuario(savedDTO.getNumIdentidad()).isPresent()) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "Ya existe usuario " + savedDTO.getNumIdentidad());
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // Convierte el DTO a entidad
                Usuario entidad = mantenimientoUsuariosMapper.toEntityTabla(savedDTO);
                entidad.setCreadoPor(usuarioLog.getId());
                entidad.setCreadoEn(new Timestamp(System.currentTimeMillis()));
                entidad.setContraseña(passwordEncoder.encode(entidad.getContraseña()));
                entidad.setUsuario(entidad.getNumIdentidad());

                // Insertar
                mantenimientoUsuariosRepository.save(entidad);

                // Log
                savedDTO = mantenimientoUsuariosMapper.toDtoTabla(entidad);
                String msj_log = "Se ha insertado el usuario " + savedDTO.getNombres();
                logMovimientoService.registrarLog("INSERT", "tbl_usuarios", entidad.getId(), null,
                                savedDTO,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        public ResponseEntity<Map<String, Object>> eliminarRegistro(Usuario usuarioLog,
                        Long idRegistro) throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Entidad existente
                Usuario existingEntity = mantenimientoUsuariosRepository.findById(idRegistro)
                                .orElse(null);

                if (existingEntity == null) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "No existe usuario con identificador " + idRegistro);

                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // DTO existente
                MantenimientoUsuariosTablaDTO existingDTO = mantenimientoUsuariosMapper
                                .toDtoTabla(existingEntity);

                // Log
                existingEntity.setEliminado(true);
                existingEntity.setActualizadoPor(usuarioLog.getId());
                existingEntity.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                String msj_log = "Se ha eliminado el usuario " + existingDTO.getUsuario();
                logMovimientoService.registrarLog("DELETE", "tbl_usuario", idRegistro, existingDTO, null,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        // -------------------------------------------------------------------
        // Ficha Usuario
        public List<MantenimientoUsuariosFichaUsuarioDTO> findFichaUsuario(Long idUsuario) {
                List<MantenimientoUsuariosFichaUsuarioDTO> allMenusObj = mantenimientoUsuariosRepository
                                .findFichaUsuario(idUsuario);
                return allMenusObj;
        }

        public ResponseEntity<Map<String, Object>> actualizarFichaUsuario(Usuario usuarioLog,
                        MantenimientoUsuariosFichaUsuarioDTO updateDTO) throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Entidad existente
                Usuario existingEntity = mantenimientoUsuariosRepository.findById(updateDTO.getId())
                                .orElse(null);

                if (existingEntity == null) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "No existe usuario con identificador " + updateDTO.getId());
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // DTO existente
                MantenimientoUsuariosFichaUsuarioDTO existingDTO = mantenimientoUsuariosMapper
                                .toDtoFichaUsuario(existingEntity);

                // Actualizar
                mantenimientoUsuariosMapper.updateFromMantenimientoUsuariosFichaUsuarioDTO(updateDTO, existingEntity);
                existingEntity.setUsuario(existingEntity.getNumIdentidad());

                // Log
                String nombreUsuario = usuarioService.getUsuarioPorId(updateDTO.getId()).getNombres();
                existingEntity.setActualizadoPor(usuarioLog.getId());
                existingEntity.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                String msj_log = "Se ha actualizado la ficha de usuario " + nombreUsuario;
                logMovimientoService.registrarLog("UPDATE", "tbl_usuarios", updateDTO.getId(), existingDTO, updateDTO,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        // -------------------------------------------------------------------
        // Ficha Laboral
        public List<MantenimientoUsuariosFichaLaboralDTO> findFichaLaboral(Long idUsuario) {
                List<MantenimientoUsuariosFichaLaboralDTO> allMenusObj = mantenimientoUsuariosRepository
                                .findFichaLaboral(idUsuario);
                return allMenusObj;
        }

        public ResponseEntity<Map<String, Object>> actualizarFichaLaboral(Usuario usuarioLog,
                        MantenimientoUsuariosFichaLaboralDTO updateDTO, MultipartFile archivoFoto)
                        throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Entidad existente
                Usuario existingEntity = mantenimientoUsuariosRepository.findById(updateDTO.getId())
                                .orElse(null);

                if (existingEntity == null) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "No existe usuario con identificador " + updateDTO.getId());
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // Subir archivo
                if (archivoFoto != null) {
                        if (!archivoFoto.isEmpty()) {
                                fileService.subirArchivoGeneral(archivoFoto,
                                                "usuarios/" + updateDTO.getId() + "/fotos");
                        }
                }

                // DTO existente
                MantenimientoUsuariosFichaLaboralDTO existingDTO = mantenimientoUsuariosMapper
                                .toDtoFichaLaboral(existingEntity);

                // Actualizar
                mantenimientoUsuariosMapper.updateFromMantenimientoUsuariosFichaLaboralDTO(updateDTO, existingEntity);

                // Log
                String nombreUsuario = usuarioService.getUsuarioPorId(updateDTO.getId()).getNombres();
                existingEntity.setActualizadoPor(usuarioLog.getId());
                existingEntity.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                String msj_log = "Se ha actualizado ficha laboral del usuario " + nombreUsuario;
                logMovimientoService.registrarLog("UPDATE", "tbl_usuarios", updateDTO.getId(), existingDTO, updateDTO,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        // -------------------------------------------------------------------
        // Ficha Dieta
        public Page<MantenimientoUsuariosFichaDietaDTO> findFichaDieta(int page, int size, String sortField,
                        String sortDirection, Long idUsuario) {
                Pageable pageable = PageRequest.of(page, size,
                                Sort.by(Sort.Direction.fromString(sortDirection), sortField));

                return mantenimientoUsuariosRepository.findFichaDieta(idUsuario,
                                pageable);
        }

        public void insertFichaDieta(Usuario usuarioLog,
                        MantenimientoUsuariosFichaDietaDTO savedDTO) throws JsonProcessingException {

                // Convierte el DTO a entidad
                UsuarioDieta entidad = mantenimientoUsuariosMapper.toEntityFichaDietaDTO(savedDTO);
                entidad.setCreadoPor(usuarioLog.getId());
                entidad.setCreadoEn(new Timestamp(System.currentTimeMillis()));

                // Insertar
                usuarioDietaRepository.save(entidad);

                // Log
                String nombreUsuario = usuarioService.getUsuarioPorId(savedDTO.getIdUsuario()).getNombres();
                String msj_log = "ha insertado dieta para el usuario " + nombreUsuario;
                logMovimientoService.registrarLog("INSERT", "tbl_usuarios_dietas", savedDTO.getIdUsuario(), null,
                                savedDTO,
                                usuarioLog.getId(), msj_log);

        }

}