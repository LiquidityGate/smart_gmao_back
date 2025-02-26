package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.IngresoDTO;
import com.gmao.gmao_backend.mapper.IngresoMapper;
import com.gmao.gmao_backend.model.Ingreso;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.IngresoRepository;
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
public class IngresoService {
    
    private final IngresoRepository ingresoRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final IngresoMapper ingresoMapper;

    public IngresoService(IngresoRepository ingresoRepository, AdministracionUsuariosRepository usuarioRepository, IngresoMapper ingresoMapper) {
        this.ingresoRepository = ingresoRepository;
        this.usuarioRepository = usuarioRepository;
        this.ingresoMapper = ingresoMapper;
    }

    // Método para validar filtros de tipo String
    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Método para validar filtros de tipo Long (para IDs)
    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field, Long value) {
        if (value != null ) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las órdenes de trabajo con filtros y paginación
    public Page<IngresoDTO> findAll(int page, int size, String sortField, String sortDirection, IngresoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Ingreso> ingresosPage = ingresoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            //predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return ingresosPage.map(ingresoMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<IngresoDTO> findById(Long id) {
        return ingresoRepository.findById(id)
                                     .map(ingresoMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public IngresoDTO save(IngresoDTO ingresoDTO) {
        /* AdministracionUsuarios solicitante = usuarioRepository.findById(ingresoDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado")); */
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Ingreso ingreso = ingresoMapper.toEntity(ingresoDTO);
        //ingreso.setSolicitante(solicitante);
    
        Ingreso savedIngreso = ingresoRepository.save(ingreso);
        return ingresoMapper.toDto(savedIngreso);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public IngresoDTO update(Long id, IngresoDTO ingresoDTO) {
        Ingreso existingIngreso = ingresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingreso no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        /* if (ingresoDTO.getSolicitanteId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(ingresoDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingIngreso.setSolicitante(solicitante);
        } */

        // Utiliza MapStruct para actualizar solo los valores no nulos
        ingresoMapper.updateFromDto(ingresoDTO, existingIngreso);

        // Guarda la entidad actualizada
        Ingreso updatedIngreso = ingresoRepository.save(existingIngreso);
        return ingresoMapper.toDto(updatedIngreso);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        ingresoRepository.deleteById(id);
    }
}