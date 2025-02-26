package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.SubfamiliaDTO;
import com.gmao.gmao_backend.mapper.SubfamiliaMapper;
import com.gmao.gmao_backend.model.Subfamilia;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.SubfamiliaRepository;
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
public class SubfamiliaService {
    
    private final SubfamiliaRepository subfamiliaRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final SubfamiliaMapper subfamiliaMapper;

    public SubfamiliaService(SubfamiliaRepository subfamiliaRepository, AdministracionUsuariosRepository usuarioRepository, SubfamiliaMapper subfamiliaMapper) {
        this.subfamiliaRepository = subfamiliaRepository;
        this.usuarioRepository = usuarioRepository;
        this.subfamiliaMapper = subfamiliaMapper;
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
    public Page<SubfamiliaDTO> findAll(int page, int size, String sortField, String sortDirection, SubfamiliaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Subfamilia> subfamiliasPage = subfamiliaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            //predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return subfamiliasPage.map(subfamiliaMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<SubfamiliaDTO> findById(Long id) {
        return subfamiliaRepository.findById(id)
                                     .map(subfamiliaMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public SubfamiliaDTO save(SubfamiliaDTO subfamiliaDTO) {
        /* AdministracionUsuarios solicitante = usuarioRepository.findById(familiaDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado")); */
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Subfamilia subfamilia = subfamiliaMapper.toEntity(subfamiliaDTO);
        //familia.setSolicitante(solicitante);
    
        Subfamilia savedSubfamilia = subfamiliaRepository.save(subfamilia);
        return subfamiliaMapper.toDto(savedSubfamilia);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public SubfamiliaDTO update(Long id, SubfamiliaDTO subfamiliaDTO) {
        Subfamilia existingSubfamilia = subfamiliaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subfamilia no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        /* if (familiaDTO.getSolicitanteId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(familiaDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingSubfamilia.setSolicitante(solicitante);
        } */

        // Utiliza MapStruct para actualizar solo los valores no nulos
        subfamiliaMapper.updateFromDto(subfamiliaDTO, existingSubfamilia);

        // Guarda la entidad actualizada
        Subfamilia updatedSubfamilia = subfamiliaRepository.save(existingSubfamilia);
        return subfamiliaMapper.toDto(updatedSubfamilia);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        subfamiliaRepository.deleteById(id);
    }
}