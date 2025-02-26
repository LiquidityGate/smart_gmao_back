package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.EspecialidadDTO;
import com.gmao.gmao_backend.mapper.EspecialidadMapper;
import com.gmao.gmao_backend.model.Especialidad;
import com.gmao.gmao_backend.repository.EspecialidadRepository;
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
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadService(EspecialidadRepository especialidadRepository, EspecialidadMapper especialidadMapper) {
        this.especialidadRepository = especialidadRepository;
        this.especialidadMapper = especialidadMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Obtener todas las especialidades con filtros y paginación
    public Page<EspecialidadDTO> findAll(int page, int size, String sortField, String sortDirection, EspecialidadDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Especialidad> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            
            // Excluir especialidades con estado "Inactivo"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<Especialidad> especialidadesPage = especialidadRepository.findAll(spec, pageable);
        return especialidadesPage.map(especialidadMapper::toDTO);
    }

    // Obtener todas las especialidades con filtros (sin paginación)
    public List<EspecialidadDTO> findAllWithoutPagination(EspecialidadDTO filterDTO) {

        Specification<Especialidad> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            // Excluir especialidades con estado "Inactivo"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<Especialidad> especialidades = especialidadRepository.findAll(spec);

        // Mapear los resultados a DTO
        return especialidades.stream()
                    .map(especialidadMapper::toDTO)
                    .collect(Collectors.toList());
    }

    public List<EspecialidadDTO> findAllForCombo() {
        return especialidadMapper.toDTOList(especialidadRepository.findByEstadoNot("Inactivo"));
    }

    // Obtener una especialidad por ID y convertirla a DTO
    public Optional<EspecialidadDTO> findById(Long id) {
        return especialidadRepository.findById(id)
                                  .map(especialidadMapper::toDTO);
    }

    // Crear una nueva especialidad
    public EspecialidadDTO save(EspecialidadDTO especialidadDTO) {
        Especialidad especialidad = especialidadMapper.toEntity(especialidadDTO);
        Especialidad savedEspecialidad = especialidadRepository.save(especialidad);
        return especialidadMapper.toDTO(savedEspecialidad);
    }

    // Actualizar una especialidad existente
    public EspecialidadDTO update(Long id, EspecialidadDTO especialidadDTO) {
        Especialidad existingEspecialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        // Actualiza solo los valores no nulos del DTO en la entidad existente
        especialidadMapper.updateFromDTO(especialidadDTO, existingEspecialidad);

        // Guarda la entidad actualizada
        Especialidad updatedEspecialidad = especialidadRepository.save(existingEspecialidad);
        return especialidadMapper.toDTO(updatedEspecialidad);
    }

    // Eliminar una especialidad por ID
    public void deleteById(Long id) {
        especialidadRepository.deleteById(id);
    }
}