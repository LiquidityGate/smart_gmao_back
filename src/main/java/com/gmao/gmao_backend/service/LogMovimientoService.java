package com.gmao.gmao_backend.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmao.gmao_backend.model.LogMovimiento;
import com.gmao.gmao_backend.repository.LogMovimientoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LogMovimientoService {

    private final LogMovimientoRepository logMovimientoRepository;

    @Autowired
    public LogMovimientoService(LogMovimientoRepository logMovimientoRepository) {
        this.logMovimientoRepository = logMovimientoRepository;
    }

    // Método para insertar un log de movimiento
    public void registrarLog(String operacion, String nombreTabla, Long registroId, Object datosAnteriores,
            Object datosNuevos, Long creadoPor, String descripcion) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Convertir los objetos a JSON usando ObjectMapper
        String datosAnterioresJson = (datosAnteriores != null) ? objectMapper.writeValueAsString(datosAnteriores)
                : null;
        String datosNuevosJson = (datosNuevos != null) ? objectMapper.writeValueAsString(datosNuevos) : null;

        // Crear el log y guardar en la base de datos
        LogMovimiento log = new LogMovimiento();
        log.setOperacion(operacion);
        log.setNombreTabla(nombreTabla);
        log.setRegistroId(registroId);
        log.setDatosAnteriores(datosAnterioresJson);
        log.setDatosNuevos(datosNuevosJson);
        log.setCreadoPor(creadoPor);
        log.setCreadoEn(new Timestamp(System.currentTimeMillis()));
        log.setDescripcion(descripcion);

        // Guardar el log
        logMovimientoRepository.save(log);
    }
}