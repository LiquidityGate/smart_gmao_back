package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.CategoriasDTO;
import com.gmao.gmao_backend.mapper.CategoriasMapper;
import com.gmao.gmao_backend.model.Categorias;
import com.gmao.gmao_backend.repository.CategoriasRepository;
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
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;
    private final CategoriasMapper categoriasMapper;

    public CategoriasService(CategoriasRepository categoriasRepository, CategoriasMapper categoriasMapper) {
        this.categoriasRepository = categoriasRepository;
        this.categoriasMapper = categoriasMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Obtener todas las categorías con filtros y paginación
    public Page<CategoriasDTO> findAll(int page, int size, String sortField, String sortDirection, CategoriasDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Categorias> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("nombrePadre"), filterDTO.getNombrePadre());
            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<Categorias> categoriasPage = categoriasRepository.findAll(spec, pageable);
        return categoriasPage.map(categoriasMapper::toDTO);
    }

    // Obtener todas las órdenes de trabajo con filtros (sin paginación)
    public List<CategoriasDTO> findAllWithoutPagination(CategoriasDTO filterDTO) {

        Specification<Categorias> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("getNombrePadre"), filterDTO.getNombrePadre());

            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<Categorias> categorias = categoriasRepository.findAll(spec);

        // Mapear los resultados a DTO
        return categorias.stream()
                    .map(categoriasMapper::toDTO)
                    .collect(Collectors.toList());
    }

    public List<CategoriasDTO> findAllForCombo() {
        return categoriasMapper.toDTOList(categoriasRepository.findByEstadoNot("Inactivo"));
    }

    // Obtener una categoría por ID y convertirla a DTO
    public Optional<CategoriasDTO> findById(Long id) {
        return categoriasRepository.findById(id)
                                  .map(categoriasMapper::toDTO);
    }

    // Crear una nueva categoría
    public CategoriasDTO save(CategoriasDTO categoriasDTO) {
        Categorias categorias = categoriasMapper.toEntity(categoriasDTO);
        Categorias savedCategorias = categoriasRepository.save(categorias);
        return categoriasMapper.toDTO(savedCategorias);
    }

    // Actualizar una categoría existente
    public CategoriasDTO update(Long id, CategoriasDTO categoriasDTO) {
        Categorias existingCategorias = categoriasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorías no encontrada"));

        // Actualiza solo los valores no nulos del DTO en la entidad existente
        categoriasMapper.updateFromDTO(categoriasDTO, existingCategorias);

        // Guarda la entidad actualizada
        Categorias updatedCategorias = categoriasRepository.save(existingCategorias);
        return categoriasMapper.toDTO(updatedCategorias);
    }

    // Eliminar una categoría por ID
    public void deleteById(Long id) {
        categoriasRepository.deleteById(id);
    }
}
