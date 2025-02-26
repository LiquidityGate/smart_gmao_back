package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.CriticidadDTO;
import com.gmao.gmao_backend.mapper.CriticidadMapper;
import com.gmao.gmao_backend.model.Criticidad;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.CriticidadRepository;
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
public class CriticidadService {
    
    private final CriticidadRepository criticidadRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final CriticidadMapper criticidadMapper;

    public CriticidadService(CriticidadRepository CriticidadRepository, AdministracionUsuariosRepository usuarioRepository, CriticidadMapper criticidadMapper) {
        this.criticidadRepository = CriticidadRepository;
        this.usuarioRepository = usuarioRepository;
        this.criticidadMapper = criticidadMapper;
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
    public Page<CriticidadDTO> findAll(int page, int size, String sortField, String sortDirection, CriticidadDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Criticidad> ordenPage = criticidadRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateNullFilters(predicates, criteriaBuilder, root.get("estado"), filterDTO.getEstado());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return ordenPage.map(criticidadMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<CriticidadDTO> findById(Long id) {
        return criticidadRepository.findById(id)
                                     .map(criticidadMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public CriticidadDTO save(CriticidadDTO criticidadDTO) {
        AdministracionUsuarios solicitante = usuarioRepository.findById(criticidadDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Criticidad criticidad = criticidadMapper.toEntity(criticidadDTO);
        criticidad.setIngresado_por(solicitante);
    
        Criticidad savedCriticidad = criticidadRepository.save(criticidad);
        return criticidadMapper.toDto(savedCriticidad);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public CriticidadDTO update(Long id, CriticidadDTO criticidadDTO) {
        Criticidad existingCriticidad = criticidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        if (criticidadDTO.getIngresado_porId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(criticidadDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingCriticidad.setIngresado_por(solicitante);
        }

        // Utiliza MapStruct para actualizar solo los valores no nulos
        criticidadMapper.updateFromDto(criticidadDTO, existingCriticidad);

        // Guarda la entidad actualizada
        Criticidad updatedOrdenTrabajo = criticidadRepository.save(existingCriticidad);
        return criticidadMapper.toDto(updatedOrdenTrabajo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        criticidadRepository.deleteById(id);
    }
}