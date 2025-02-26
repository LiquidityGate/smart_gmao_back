package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_log_detallesDTO;
import com.gmao.gmao_backend.mapper.Usu_log_detallesMapper;
import com.gmao.gmao_backend.model.Usu_log_detalles;
import com.gmao.gmao_backend.repository.Usu_log_detallesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Usu_log_detallesService {

    private final Usu_log_detallesRepository repository;
    private final Usu_log_detallesMapper mapper;

    public Usu_log_detallesService(Usu_log_detallesRepository repository, Usu_log_detallesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<Usu_log_detallesDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_log_detallesDTO filtros) {
        Pageable pageable = PageRequest.of(page, size);
        Long creadoPor = filtros != null ? filtros.getCreado_por() : null;
        
        Page<Usu_log_detalles> result = repository.findUsu_log_detallesByCreadoPor(
            creadoPor, 
            sortField, 
            sortDirection,
            pageable
        );
        
        return result.map(mapper::toDTO);
    }

    public Optional<Usu_log_detallesDTO> findById(Long creado_por) {
        return repository.findById(creado_por).map(mapper::toDTO);
    }
}
