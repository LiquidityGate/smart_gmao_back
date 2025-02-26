package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.CategoriaDTO;
import com.gmao.gmao_backend.dto.SubcategoriaDTO;
import com.gmao.gmao_backend.mapper.SubcategoriaMapper;
import com.gmao.gmao_backend.model.Categoria;
import com.gmao.gmao_backend.model.Subcategoria;
import com.gmao.gmao_backend.repository.CategoriaRepository;
import com.gmao.gmao_backend.repository.SubcategoriaRepository;
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
public class SubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;
    private final CategoriaRepository categoriaRepository;
    private final SubcategoriaMapper subcategoriaMapper;

    public SubcategoriaService(SubcategoriaRepository subcategoriaRepository, CategoriaRepository categoriaRepository, SubcategoriaMapper subcategoriaMapper) {
        this.subcategoriaRepository = subcategoriaRepository;
        this.categoriaRepository = categoriaRepository;
        this.subcategoriaMapper = subcategoriaMapper;
    }

    // Método para validar filtros de tipo String
    private void validateStringFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Método para validar filtros de tipo Long (para IDs)
    private void validateIdFilter(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field, Long value) {
        if (value != null) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las subcategorías con filtros y paginación
    public Page<SubcategoriaDTO> findAll(int page, int size, String sortField, String sortDirection, SubcategoriaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Subcategoria> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            validateIdFilter(predicates, criteriaBuilder, root.get("categoria").get("id"), filterDTO.getCategoriaId());

            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<Subcategoria> subcategoriasPage = subcategoriaRepository.findAll(spec, pageable);
        return subcategoriasPage.map(subcategoria -> {
            SubcategoriaDTO subcategoriaDTO = subcategoriaMapper.toDTO(subcategoria);

            // Llenar categoriaId y categoriaNombre en el DTO
            subcategoriaDTO.setCategoriaId(subcategoria.getCategoria().getId());
            subcategoriaDTO.setCategoriaNombre(subcategoria.getCategoria().getNombre());

            return subcategoriaDTO;
        });
    }

    // Obtener todas las órdenes de trabajo con filtros (sin paginación)
    public List<SubcategoriaDTO> findAllWithoutPagination(SubcategoriaDTO filterDTO) {

        Specification<Subcategoria> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateStringFilter(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateStringFilter(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Inactivo"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio sin paginación
        List<Subcategoria> subcategorias = subcategoriaRepository.findAll(spec);

        // Mapear los resultados a DTO
        return subcategorias.stream()
                    .map(subcategoriaMapper::toDTO)
                    .collect(Collectors.toList());
    }

    // Obtener una subcategoría por ID y convertirla a DTO
    public Optional<SubcategoriaDTO> findById(Long id) {
        return subcategoriaRepository.findById(id).map(subcategoria -> {
            SubcategoriaDTO subcategoriaDTO = subcategoriaMapper.toDTO(subcategoria);

            // Llenar categoriaId y categoriaNombre en el DTO
            subcategoriaDTO.setCategoriaId(subcategoria.getCategoria().getId());
            subcategoriaDTO.setCategoriaNombre(subcategoria.getCategoria().getNombre());

            return subcategoriaDTO;
        });
    }

    // Crear una nueva subcategoría
    public SubcategoriaDTO save(SubcategoriaDTO subcategoriaDTO) {
        Categoria categoria = categoriaRepository.findById(subcategoriaDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        
        Subcategoria subcategoria = subcategoriaMapper.toEntity(subcategoriaDTO);
        subcategoria.setCategoria(categoria);
        
        Subcategoria savedSubcategoria = subcategoriaRepository.save(subcategoria);
        return subcategoriaMapper.toDTO(savedSubcategoria);
    }

    // Actualizar una subcategoría existente
    public SubcategoriaDTO update(Long id, SubcategoriaDTO subcategoriaDTO) {
        Subcategoria existingSubcategoria = subcategoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));

        if (subcategoriaDTO.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(subcategoriaDTO.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            existingSubcategoria.setCategoria(categoria);
        }

        // Actualización parcial con valores no nulos del DTO
        subcategoriaMapper.updateFromDTO(subcategoriaDTO, existingSubcategoria);

        Subcategoria updatedSubcategoria = subcategoriaRepository.save(existingSubcategoria);
        return subcategoriaMapper.toDTO(updatedSubcategoria);
    }

    // Eliminar una subcategoría por ID
    public void deleteById(Long id) {
        subcategoriaRepository.deleteById(id);
    }
}