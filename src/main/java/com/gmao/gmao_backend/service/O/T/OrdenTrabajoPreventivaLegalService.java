package com.gmao.gmao_backend.service.O.T;


import com.gmao.gmao_backend.dto.O.T.OrdenTrabajoPreventivaLegalDTO;
import com.gmao.gmao_backend.exception.ResourceNotFoundException;
import com.gmao.gmao_backend.mapper.O.T.OrdenTrabajoPreventivaLegalMapper;
import com.gmao.gmao_backend.model.O.T.OrdenTrabajoPreventivaLegal;
import com.gmao.gmao_backend.repository.O.T.OrdenTrabajoPreventivaLegalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrdenTrabajoPreventivaLegalService {
    private final OrdenTrabajoPreventivaLegalRepository repository;
    private final OrdenTrabajoPreventivaLegalMapper mapper;

    public List<OrdenTrabajoPreventivaLegalDTO.Response> getAllOrdenes() {
        List<OrdenTrabajoPreventivaLegal> ordenes = repository.findAll();
        return mapper.toDtoList(ordenes);
    }

    public OrdenTrabajoPreventivaLegalDTO.Response getOrdenById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Orden de trabajo no encontrada con id: " + id));
    }

    public OrdenTrabajoPreventivaLegalDTO.Response getOrdenByPeriodo(String periodo) {
        return repository.findFirstByPeriodoOrderByFechaActualizacionDesc(periodo)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Orden de trabajo no encontrada para el periodo: " + periodo));
    }

    public OrdenTrabajoPreventivaLegalDTO.Response crearOrden(OrdenTrabajoPreventivaLegalDTO.Request request) {
        log.info("Creando nueva orden de trabajo para periodo: {}", request.getPeriodo());

        // Inicializar valores nulos
        if (request.getOrdenesFinalizadas() == null) {
            request.setOrdenesFinalizadas(0);
        }
        if (request.getOrdenesPendientes() == null) {
            request.setOrdenesPendientes(0);
        }
        if (request.getHorasRealesFinalizadas() == null) {
            request.setHorasRealesFinalizadas(BigDecimal.ZERO);
        }
        if (request.getHorasPrevistasFinalizadas() == null) {
            request.setHorasPrevistasFinalizadas(BigDecimal.ZERO);
        }
        if (request.getHorasPrevistasPendientes() == null) {
            request.setHorasPrevistasPendientes(BigDecimal.ZERO);
        }

        // Verificar si ya existe una orden para este periodo
        Optional<OrdenTrabajoPreventivaLegal> existente = repository
                .findFirstByPeriodoOrderByFechaActualizacionDesc(request.getPeriodo());

        if (existente.isPresent()) {
            log.info("Ya existe una orden para el periodo {}. Actualizando...", request.getPeriodo());
            OrdenTrabajoPreventivaLegal entidad = existente.get();
            mapper.updateEntityFromDto(request, entidad);
            return mapper.toDto(repository.save(entidad));
        } else {
            OrdenTrabajoPreventivaLegal nuevaOrden = mapper.toEntity(request);
            return mapper.toDto(repository.save(nuevaOrden));
        }
    }

    public OrdenTrabajoPreventivaLegalDTO.Response actualizarOrden(Long id, OrdenTrabajoPreventivaLegalDTO.Request request) {
        log.info("Actualizando orden de trabajo con id: {}", id);

        OrdenTrabajoPreventivaLegal orden = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden de trabajo no encontrada con id: " + id));

        mapper.updateEntityFromDto(request, orden);
        return mapper.toDto(repository.save(orden));
    }

    public void eliminarOrden(Long id) {
        log.info("Eliminando orden de trabajo con id: {}", id);

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Orden de trabajo no encontrada con id: " + id);
        }

        repository.deleteById(id);
    }

    public OrdenTrabajoPreventivaLegalDTO.ResumenDTO getResumen() {
        Integer ordenesFinalizadas = repository.getTotalOrdenesFinalizadasAnual();
        Integer ordenesPendientes = repository.getTotalOrdenesPendientesAnual();

        Integer totalOrdenes = ordenesFinalizadas + ordenesPendientes;

        BigDecimal porcentajeAvance = BigDecimal.ZERO;
        if (totalOrdenes > 0) {
            porcentajeAvance = BigDecimal.valueOf(ordenesFinalizadas * 100.0 / totalOrdenes)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        // Esto podría extenderse para obtener más información resumida

        return OrdenTrabajoPreventivaLegalDTO.ResumenDTO.builder()
                .totalOrdenesFinalizadas(ordenesFinalizadas)
                .totalOrdenesPendientes(ordenesPendientes)
                .totalOrdenes(totalOrdenes)
                .porcentajeAvance(porcentajeAvance)
                .build();
    }

    public void inicializarDatosDemo() {
        // Solo inicializar si no existen datos
        if (repository.count() == 0) {
            log.info("Inicializando datos de demostración para órdenes de trabajo preventivas legal");

            // Crear datos para el mes actual
            OrdenTrabajoPreventivaLegalDTO.Request mesActual = new OrdenTrabajoPreventivaLegalDTO.Request();
            mesActual.setPeriodo("Mes actual");
            mesActual.setOrdenesFinalizadas(0);
            mesActual.setHorasRealesFinalizadas(BigDecimal.ZERO);
            mesActual.setHorasPrevistasFinalizadas(BigDecimal.ZERO);
            mesActual.setOrdenesPendientes(4);
            mesActual.setHorasPrevistasPendientes(new BigDecimal("3.22"));

            // Crear datos para el año actual
            OrdenTrabajoPreventivaLegalDTO.Request anioActual = new OrdenTrabajoPreventivaLegalDTO.Request();
            anioActual.setPeriodo("Año actual");
            anioActual.setOrdenesFinalizadas(0);
            anioActual.setHorasRealesFinalizadas(BigDecimal.ZERO);
            anioActual.setHorasPrevistasFinalizadas(BigDecimal.ZERO);
            anioActual.setOrdenesPendientes(4);
            anioActual.setHorasPrevistasPendientes(new BigDecimal("3.22"));

            crearOrden(mesActual);
            crearOrden(anioActual);

            log.info("Datos de demostración inicializados correctamente");
        }
    }
}