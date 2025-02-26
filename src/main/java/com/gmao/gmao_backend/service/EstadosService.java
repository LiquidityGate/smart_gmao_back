package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.EstadosDTO;
import com.gmao.gmao_backend.mapper.EstadosMapper;
import com.gmao.gmao_backend.model.Estados;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.EstadosRepository;
import com.gmao.gmao_backend.repository.AdministracionUsuariosRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstadosService {
    
    private final EstadosRepository estadosRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final EstadosMapper estadosMapper;

    public EstadosService(EstadosRepository EstadosRepository, AdministracionUsuariosRepository usuarioRepository, EstadosMapper estadosMapper) {
        this.estadosRepository = EstadosRepository;
        this.usuarioRepository = usuarioRepository;
        this.estadosMapper = estadosMapper;
    }

    // Método para validar filtros de tipo String
    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Método para validar filtros de tipo Long (para IDs)
    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, Integer value) {
        if (value != null && value > 0 ) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las órdenes de trabajo con filtros y paginación
    public Page<EstadosDTO> findAll(int page, int size, String sortField, String sortDirection, EstadosDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Estados> ordenPage = estadosRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateNullFilters(predicates, criteriaBuilder, root.get("estado"), filterDTO.getEstado());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return ordenPage.map(estadosMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<EstadosDTO> findById(Long id) {
        return estadosRepository.findById(id)
                                     .map(estadosMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public EstadosDTO save(EstadosDTO estadosDTO) {
        AdministracionUsuarios solicitante = usuarioRepository.findById(estadosDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Estados estados = estadosMapper.toEntity(estadosDTO);
        estados.setIngresado_por(solicitante);
    
        Estados savedEstados = estadosRepository.save(estados);
        return estadosMapper.toDto(savedEstados);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public EstadosDTO update(Long id, EstadosDTO estadosDTO) {
        Estados existingEstados = estadosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        if (estadosDTO.getIngresado_porId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(estadosDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingEstados.setIngresado_por(solicitante);
        }

        // Utiliza MapStruct para actualizar solo los valores no nulos
        estadosMapper.updateFromDto(estadosDTO, existingEstados);

        // Guarda la entidad actualizada
        Estados updatedOrdenTrabajo = estadosRepository.save(existingEstados);
        return estadosMapper.toDto(updatedOrdenTrabajo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        estadosRepository.deleteById(id);
    }
}