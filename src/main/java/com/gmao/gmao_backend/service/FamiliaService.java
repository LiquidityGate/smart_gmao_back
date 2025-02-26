package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.FamiliaDTO;
import com.gmao.gmao_backend.mapper.FamiliaMapper;
import com.gmao.gmao_backend.model.Familia;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.FamiliaRepository;
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
public class FamiliaService {
    
    private final FamiliaRepository familiaRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final FamiliaMapper familiaMapper;

    public FamiliaService(FamiliaRepository familiaRepository, AdministracionUsuariosRepository usuarioRepository, FamiliaMapper familiaMapper) {
        this.familiaRepository = familiaRepository;
        this.usuarioRepository = usuarioRepository;
        this.familiaMapper = familiaMapper;
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
    public Page<FamiliaDTO> findAll(int page, int size, String sortField, String sortDirection, FamiliaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Familia> familiasPage = familiaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            //predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return familiasPage.map(familiaMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<FamiliaDTO> findById(Long id) {
        return familiaRepository.findById(id)
                                     .map(familiaMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public FamiliaDTO save(FamiliaDTO familiaDTO) {
        /* AdministracionUsuarios solicitante = usuarioRepository.findById(familiaDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado")); */
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Familia familia = familiaMapper.toEntity(familiaDTO);
        //familia.setSolicitante(solicitante);
    
        Familia savedFamilia = familiaRepository.save(familia);
        return familiaMapper.toDto(savedFamilia);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public FamiliaDTO update(Long id, FamiliaDTO familiaDTO) {
        Familia existingFamilia = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        /* if (familiaDTO.getSolicitanteId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(familiaDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingFamilia.setSolicitante(solicitante);
        } */

        // Utiliza MapStruct para actualizar solo los valores no nulos
        familiaMapper.updateFromDto(familiaDTO, existingFamilia);

        // Guarda la entidad actualizada
        Familia updatedFamilia = familiaRepository.save(existingFamilia);
        return familiaMapper.toDto(updatedFamilia);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        familiaRepository.deleteById(id);
    }
}