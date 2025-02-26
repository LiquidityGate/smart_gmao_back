package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.CategoriaDTO;
import com.gmao.gmao_backend.dto.OrdenTrabajoDTO;
import com.gmao.gmao_backend.mapper.CategoriaMapper;
import com.gmao.gmao_backend.model.Categoria;
import com.gmao.gmao_backend.model.OrdenTrabajo;
import com.gmao.gmao_backend.repository.CategoriaRepository;
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
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Obtener todas las categorías con filtros y paginación
    public Page<CategoriaDTO> findAll(int page, int size, String sortField, String sortDirection, CategoriaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Categoria> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<Categoria> categoriasPage = categoriaRepository.findAll(spec, pageable);
        return categoriasPage.map(categoriaMapper::toDTO);
    }

    // Obtener todas las órdenes de trabajo con filtros (sin paginación)
    public List<CategoriaDTO> findAllWithoutPagination(CategoriaDTO filterDTO) {

        Specification<Categoria> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<Categoria> categorias = categoriaRepository.findAll(spec);

        // Mapear los resultados a DTO
        return categorias.stream()
                    .map(categoriaMapper::toDTO)
                    .collect(Collectors.toList());
    }

    public List<CategoriaDTO> findAllForCombo() {
        return categoriaMapper.toDTOList(categoriaRepository.findByEstadoNot("Inactivo"));
    }

    // Obtener una categoría por ID y convertirla a DTO
    public Optional<CategoriaDTO> findById(Long id) {
        return categoriaRepository.findById(id)
                                  .map(categoriaMapper::toDTO);
    }

    // Crear una nueva categoría
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(savedCategoria);
    }

    // Actualizar una categoría existente
    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        Categoria existingCategoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Actualiza solo los valores no nulos del DTO en la entidad existente
        categoriaMapper.updateFromDTO(categoriaDTO, existingCategoria);

        // Guarda la entidad actualizada
        Categoria updatedCategoria = categoriaRepository.save(existingCategoria);
        return categoriaMapper.toDTO(updatedCategoria);
    }

    // Eliminar una categoría por ID
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}