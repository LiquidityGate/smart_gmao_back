package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.PrioridadDTO;
import com.gmao.gmao_backend.mapper.PrioridadMapper;
import com.gmao.gmao_backend.model.Prioridad;
import com.gmao.gmao_backend.repository.PrioridadRepository;
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
public class PrioridadService {

    private final PrioridadRepository prioridadRepository;
    private final PrioridadMapper prioridadMapper;

    public PrioridadService(PrioridadRepository prioridadRepository, PrioridadMapper prioridadMapper) {
        this.prioridadRepository = prioridadRepository;
        this.prioridadMapper = prioridadMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Obtener todas las prioridades con filtros y paginación
    public Page<PrioridadDTO> findAll(int page, int size, String sortField, String sortDirection, PrioridadDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Prioridad> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            
            // Excluir prioridades con estado "Eliminado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<Prioridad> prioridadesPage = prioridadRepository.findAll(spec, pageable);
        return prioridadesPage.map(prioridadMapper::toDTO);
    }

    // Obtener todas las prioridades con filtros (sin paginación)
    public List<PrioridadDTO> findAllWithoutPagination(PrioridadDTO filterDTO) {

        Specification<Prioridad> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            // Excluir prioridades con estado "Eliminado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<Prioridad> prioridades = prioridadRepository.findAll(spec);

        // Mapear los resultados a DTO
        return prioridades.stream()
                    .map(prioridadMapper::toDTO)
                    .collect(Collectors.toList());
    }

    public List<PrioridadDTO> findAllForCombo() {
        return prioridadMapper.toDTOList(prioridadRepository.findByEstadoNot("Inactivo"));
    }

    // Obtener una prioridad por ID y convertirla a DTO
    public Optional<PrioridadDTO> findById(Long id) {
        return prioridadRepository.findById(id)
                                  .map(prioridadMapper::toDTO);
    }

    // Crear una nueva prioridad
    public PrioridadDTO save(PrioridadDTO prioridadDTO) {
        Prioridad prioridad = prioridadMapper.toEntity(prioridadDTO);
        Prioridad savedPrioridad = prioridadRepository.save(prioridad);
        return prioridadMapper.toDTO(savedPrioridad);
    }

    // Actualizar una prioridad existente
    public PrioridadDTO update(Long id, PrioridadDTO prioridadDTO) {
        Prioridad existingPrioridad = prioridadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));

        // Actualiza solo los valores no nulos del DTO en la entidad existente
        prioridadMapper.updateFromDTO(prioridadDTO, existingPrioridad);

        // Guarda la entidad actualizada
        Prioridad updatedPrioridad = prioridadRepository.save(existingPrioridad);
        return prioridadMapper.toDTO(updatedPrioridad);
    }

    // Eliminar una prioridad por ID
    public void deleteById(Long id) {
        prioridadRepository.deleteById(id);
    }
}