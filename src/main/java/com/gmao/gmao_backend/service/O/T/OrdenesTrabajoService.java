package com.gmao.gmao_backend.service.O.T;

import com.gmao.gmao_backend.dto.O.T.OrdenesTrabajoDTO;
import com.gmao.gmao_backend.exception.ResourceNotFoundException;
import com.gmao.gmao_backend.mapper.O.T.OrdenesTrabajoMapper;
import com.gmao.gmao_backend.model.O.T.OrdenesTrabajo;
import com.gmao.gmao_backend.repository.O.T.OrdenesTrabajoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrdenesTrabajoService {

    private final OrdenesTrabajoRepository repository;
    private final OrdenesTrabajoMapper mapper;

    // Tipos de órdenes de trabajo disponibles
    private final List<OrdenesTrabajoDTO.TipoDTO> tiposDisponibles = Arrays.asList(
            new OrdenesTrabajoDTO.TipoDTO("preventivas-legal", "Órdenes de trabajo preventivas legal", "#6c8dfa"),
            new OrdenesTrabajoDTO.TipoDTO("correctivas", "Órdenes de trabajo correctivas", "#7cdc8c"),
            new OrdenesTrabajoDTO.TipoDTO("predictivas", "Órdenes de trabajo predictivas", "#21ccb0"),
            new OrdenesTrabajoDTO.TipoDTO("preventivas", "Órdenes de trabajo predictivas", "#21ccbs")
    );

    /**
     * Obtiene todos los tipos de órdenes de trabajo disponibles
     */
    public List<OrdenesTrabajoDTO.TipoDTO> getTiposOrdenesTrabajo() {
        return tiposDisponibles;
    }
    /**
     * Obtiene todas las órdenes de trabajo
     */
    public List<OrdenesTrabajoDTO.Response> getAllOrdenes() {
        List<OrdenesTrabajo> ordenes = repository.findAll();
        return mapper.toDtoList(ordenes);
    }

    /**
     * Obtiene todas las órdenes de trabajo de un tipo específico
     */
    public List<OrdenesTrabajoDTO.Response> getOrdenesByTipo(String tipo) {
        List<OrdenesTrabajo> ordenes = repository.findByTipo(tipo);
        return mapper.toDtoList(ordenes);
    }
}