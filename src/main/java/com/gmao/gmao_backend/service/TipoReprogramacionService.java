package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.TipoReprogramacionDTO;
import com.gmao.gmao_backend.mapper.TipoReprogramacionMapper;
import com.gmao.gmao_backend.model.TipoReprogramacion;
import com.gmao.gmao_backend.repository.TipoReprogramacionRepository;
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
public class TipoReprogramacionService {

    private final TipoReprogramacionRepository tipoReprogramacionRepository;
    private final TipoReprogramacionMapper tipoReprogramacionMapper;

    public TipoReprogramacionService(TipoReprogramacionRepository tipoReprogramacionRepository, TipoReprogramacionMapper tipoReprogramacionMapper) {
        this.tipoReprogramacionRepository = tipoReprogramacionRepository;
        this.tipoReprogramacionMapper = tipoReprogramacionMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Obtener todas las reprogramaciones con filtros y paginación
    public Page<TipoReprogramacionDTO> findAll(int page, int size, String sortField, String sortDirection, TipoReprogramacionDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<TipoReprogramacion> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            
            // Excluir reprogramaciones con estado "Inactivo"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<TipoReprogramacion> reprogramacionesPage = tipoReprogramacionRepository.findAll(spec, pageable);
        return reprogramacionesPage.map(tipoReprogramacionMapper::toDTO);
    }

    // Obtener todas las reprogramaciones con filtros (sin paginación)
    public List<TipoReprogramacionDTO> findAllWithoutPagination(TipoReprogramacionDTO filterDTO) {

        Specification<TipoReprogramacion> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            // Excluir reprogramaciones con estado "Inactivo"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<TipoReprogramacion> reprogramaciones = tipoReprogramacionRepository.findAll(spec);

        // Mapear los resultados a DTO
        return reprogramaciones.stream()
                    .map(tipoReprogramacionMapper::toDTO)
                    .collect(Collectors.toList());
    }

    public List<TipoReprogramacionDTO> findAllForCombo() {
        return tipoReprogramacionMapper.toDTOList(tipoReprogramacionRepository.findByEstadoNot("Inactivo"));
    }

    // Obtener una reprogramación por ID y convertirla a DTO
    public Optional<TipoReprogramacionDTO> findById(Long id) {
        return tipoReprogramacionRepository.findById(id)
                                  .map(tipoReprogramacionMapper::toDTO);
    }

    // Crear una nueva reprogramación
    public TipoReprogramacionDTO save(TipoReprogramacionDTO tipoReprogramacionDTO) {
        TipoReprogramacion tipoReprogramacion = tipoReprogramacionMapper.toEntity(tipoReprogramacionDTO);
        TipoReprogramacion savedReprogramacion = tipoReprogramacionRepository.save(tipoReprogramacion);
        return tipoReprogramacionMapper.toDTO(savedReprogramacion);
    }

    // Actualizar una reprogramación existente
    public TipoReprogramacionDTO update(Long id, TipoReprogramacionDTO tipoReprogramacionDTO) {
        TipoReprogramacion existingReprogramacion = tipoReprogramacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de Reprogramación no encontrado"));

        // Actualiza solo los valores no nulos del DTO en la entidad existente
        tipoReprogramacionMapper.updateFromDTO(tipoReprogramacionDTO, existingReprogramacion);

        // Guarda la entidad actualizada
        TipoReprogramacion updatedReprogramacion = tipoReprogramacionRepository.save(existingReprogramacion);
        return tipoReprogramacionMapper.toDTO(updatedReprogramacion);
    }

    // Eliminar una reprogramación por ID
    public void deleteById(Long id) {
        tipoReprogramacionRepository.deleteById(id);
    }
}