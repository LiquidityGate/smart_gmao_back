package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_categoriaDTO;
import com.gmao.gmao_backend.mapper.Alm_categoriaMapper;
import com.gmao.gmao_backend.model.Alm_categoria;
import com.gmao.gmao_backend.repository.Alm_categoriaRepository;
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
public class Alm_categoriaService {
    
    private final Alm_categoriaRepository alm_categoriaRepository;
    private final Alm_categoriaMapper alm_categoriaMapper;

    public Alm_categoriaService(Alm_categoriaRepository alm_categoriaRepository, AdministracionUsuariosRepository usuarioRepository, Alm_categoriaMapper alm_categoriaMapper) {
        this.alm_categoriaRepository = alm_categoriaRepository;
        this.alm_categoriaMapper = alm_categoriaMapper;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field, Long value) {
        if (value != null ) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    public Page<Alm_categoriaDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_categoriaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_categoria> alm_categoriasPage = alm_categoriaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("categoria"), filterDTO.getCategoria());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_categoriasPage.map(alm_categoriaMapper::toDto);
    }

    public Optional<Alm_categoriaDTO> findById(Long id) {
        return alm_categoriaRepository.findById(id)
                                     .map(alm_categoriaMapper::toDto);
    }

    public Alm_categoriaDTO save(Alm_categoriaDTO alm_categoriaDTO) {
        Alm_categoria alm_categoria = alm_categoriaMapper.toEntity(alm_categoriaDTO);
        Alm_categoria savedAlm_categoria = alm_categoriaRepository.save(alm_categoria);
        return alm_categoriaMapper.toDto(savedAlm_categoria);
    }

    public Alm_categoriaDTO update(Long id, Alm_categoriaDTO alm_categoriaDTO) {
        Alm_categoria existingAlm_categoria = alm_categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_categoria no encontrada"));

        alm_categoriaMapper.updateFromDto(alm_categoriaDTO, existingAlm_categoria);

        Alm_categoria updatedAlm_categoria = alm_categoriaRepository.save(existingAlm_categoria);
        return alm_categoriaMapper.toDto(updatedAlm_categoria);
    }

    public void deleteById(Long id) {
        alm_categoriaRepository.deleteById(id);
    }
}