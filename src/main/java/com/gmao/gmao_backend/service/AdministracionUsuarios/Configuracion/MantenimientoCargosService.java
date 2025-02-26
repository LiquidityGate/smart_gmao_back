package com.gmao.gmao_backend.service.AdministracionUsuarios.Configuracion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosTablaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosVistaDTO;
import com.gmao.gmao_backend.mapper.AdministracionUsuarios.Configuracion.MantenimientoCargosMapper;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.model.UsuarioCargo;
import com.gmao.gmao_backend.repository.AdministracionUsuarios.Configuracion.MantenimientoCargosRepository;
import com.gmao.gmao_backend.service.LogMovimientoService;
import com.gmao.gmao_backend.service.UsuarioService;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class MantenimientoCargosService {

        private final MantenimientoCargosRepository mantenimientoCargosRepository;
        private final MantenimientoCargosMapper mantenimientoCargosMapper;
        private final LogMovimientoService logMovimientoService;

        public MantenimientoCargosService(
                        LogMovimientoService logMovimientoService, UsuarioService usuarioService,
                        MantenimientoCargosRepository mantenimientoCargosRepository,
                        MantenimientoCargosMapper mantenimientoCargosMapper) {
                this.logMovimientoService = logMovimientoService;
                this.mantenimientoCargosRepository = mantenimientoCargosRepository;
                this.mantenimientoCargosMapper = mantenimientoCargosMapper;
        }

        // -------------------------------------------------------------------
        // Tabla principal
        public ResponseEntity<Page<MantenimientoCargosTablaDTO>> verRegistros(int page, int size, String sortField,
                        String sortDirection, MantenimientoCargosTablaDTO filterDTO) {
                Pageable pageable = PageRequest.of(page, size,
                                Sort.by(Sort.Direction.fromString(sortDirection), sortField));
                Page<MantenimientoCargosTablaDTO> tabla = mantenimientoCargosRepository.findTabla(filterDTO,
                                pageable);
                return new ResponseEntity<>(tabla, HttpStatus.OK);
        }

        public ResponseEntity<Map<String, Object>> insertarRegistro(Usuario usuarioLog,
                        MantenimientoCargosTablaDTO savedDTO) throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Verifica si ya existe
                if (mantenimientoCargosRepository.findByNombre(savedDTO.getNombre()).isPresent()) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "Ya existe cargo con nombre " + savedDTO.getNombre());
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // Convierte el DTO a entidad
                UsuarioCargo entidad = mantenimientoCargosMapper.toEntityTabla(savedDTO);
                entidad.setCreadoPor(usuarioLog.getId());
                entidad.setCreadoEn(new Timestamp(System.currentTimeMillis()));

                // Insertar
                mantenimientoCargosRepository.save(entidad);

                // Log
                savedDTO = mantenimientoCargosMapper.toDtoTabla(entidad);
                String msj_log = "Se ha insertado el cargo " + savedDTO.getNombre();
                logMovimientoService.registrarLog("INSERT", "g_usr_cargos", entidad.getId(), null,
                                savedDTO,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        public ResponseEntity<Map<String, Object>> actualizarRegistro(Usuario usuarioLog,
                        MantenimientoCargosTablaDTO updateDTO) throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Entidad existente
                UsuarioCargo existingEntity = mantenimientoCargosRepository.findById(updateDTO.getId())
                                .orElse(null);

                if (existingEntity == null) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "No existe cargo con identificador " + updateDTO.getId());
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // DTO existente
                MantenimientoCargosTablaDTO existingDTO = mantenimientoCargosMapper
                                .toDtoTabla(existingEntity);

                // Actualizar
                mantenimientoCargosMapper.updateFromDto(updateDTO, existingEntity);

                // Log
                existingEntity.setActualizadoPor(usuarioLog.getId());
                existingEntity.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                String msj_log = "Se ha actualizado el cargo " + existingDTO.getNombre();
                logMovimientoService.registrarLog("UPDATE", "g_usr_cargos", updateDTO.getId(), existingDTO, updateDTO,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        public ResponseEntity<Map<String, Object>> eliminarRegistro(Usuario usuarioLog,
                        Long idRegistro) throws JsonProcessingException {

                Map<String, Object> respuesta = new HashMap<>();

                // Entidad existente
                UsuarioCargo existingEntity = mantenimientoCargosRepository.findById(idRegistro)
                                .orElse(null);

                if (existingEntity == null) {
                        respuesta.put("estado", 0);
                        respuesta.put("mensaje", "No existe cargo con identificador " + idRegistro);

                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                }

                // DTO existente
                MantenimientoCargosTablaDTO existingDTO = mantenimientoCargosMapper
                                .toDtoTabla(existingEntity);

                // Log
                existingEntity.setEliminado(true);
                existingEntity.setActualizadoPor(usuarioLog.getId());
                existingEntity.setActualizadoEn(new Timestamp(System.currentTimeMillis()));
                String msj_log = "Se ha eliminado el cargo " + existingDTO.getNombre();
                logMovimientoService.registrarLog("DELETE", "g_usr_cargos", idRegistro, existingDTO, null,
                                usuarioLog.getId(), msj_log);

                respuesta.put("estado", 1);
                respuesta.put("mensaje", msj_log);

                return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }

        public ResponseEntity<List<MantenimientoCargosVistaDTO>> verRegistroPorID(Long idRegistro) {
                List<MantenimientoCargosVistaDTO> registro = mantenimientoCargosRepository
                                .verRegistroPorID(idRegistro);
                return new ResponseEntity<>(registro, HttpStatus.OK);
        }

}