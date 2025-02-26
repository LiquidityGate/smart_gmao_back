package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.FrecuenciaDTO;
import com.gmao.gmao_backend.mapper.FrecuenciaMapper;
import com.gmao.gmao_backend.model.Frecuencia;
import com.gmao.gmao_backend.repository.FrecuenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FrecuenciaService {

    private final FrecuenciaRepository frecuenciaRepository;
    private final FrecuenciaMapper frecuenciaMapper;

    public FrecuenciaService(FrecuenciaRepository frecuenciaRepository, FrecuenciaMapper frecuenciaMapper) {
        this.frecuenciaRepository = frecuenciaRepository;
        this.frecuenciaMapper = frecuenciaMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Obtener todas las frecuencias con filtros y paginación
    public Page<FrecuenciaDTO> findAll(int page, int size, String sortField, String sortDirection, FrecuenciaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Frecuencia> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            
            // Excluir frecuencias con estado "Inactivo"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<Frecuencia> frecuenciasPage = frecuenciaRepository.findAll(spec, pageable);
        return frecuenciasPage.map(frecuenciaMapper::toDTO);
    }

    // Obtener todas las frecuencias con filtros (sin paginación)
    public List<FrecuenciaDTO> findAllWithoutPagination(FrecuenciaDTO filterDTO) {

        Specification<Frecuencia> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            // Excluir frecuencias con estado "Inactivo"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<Frecuencia> frecuencias = frecuenciaRepository.findAll(spec);

        // Mapear los resultados a DTO
        return frecuencias.stream()
                    .map(frecuenciaMapper::toDTO)
                    .collect(Collectors.toList());
    }

    public List<FrecuenciaDTO> findAllForCombo() {
        return frecuenciaMapper.toDTOList(frecuenciaRepository.findByEstadoNot("Inactivo"));
    }

    // Obtener una frecuencia por ID y convertirla a DTO
    public Optional<FrecuenciaDTO> findById(Long id) {
        return frecuenciaRepository.findById(id)
                                  .map(frecuenciaMapper::toDTO);
    }

    // Crear una nueva frecuencia
    public FrecuenciaDTO save(FrecuenciaDTO frecuenciaDTO) {
        Frecuencia frecuencia = frecuenciaMapper.toEntity(frecuenciaDTO);
        Frecuencia savedFrecuencia = frecuenciaRepository.save(frecuencia);
        return frecuenciaMapper.toDTO(savedFrecuencia);
    }

    // Actualizar una frecuencia existente
    public FrecuenciaDTO update(Long id, FrecuenciaDTO frecuenciaDTO) {
        Frecuencia existingFrecuencia = frecuenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Frecuencia no encontrada"));

        // Actualiza solo los valores no nulos del DTO en la entidad existente
        frecuenciaMapper.updateFromDTO(frecuenciaDTO, existingFrecuencia);

        // Guarda la entidad actualizada
        Frecuencia updatedFrecuencia = frecuenciaRepository.save(existingFrecuencia);
        return frecuenciaMapper.toDTO(updatedFrecuencia);
    }

    // Eliminar una frecuencia por ID
    public void deleteById(Long id) {
        frecuenciaRepository.deleteById(id);
    }
}