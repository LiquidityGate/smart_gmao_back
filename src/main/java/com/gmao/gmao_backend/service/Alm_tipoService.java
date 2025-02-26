package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_tipoDTO;
import com.gmao.gmao_backend.mapper.Alm_tipoMapper;
import com.gmao.gmao_backend.model.Alm_tipo;
import com.gmao.gmao_backend.repository.Alm_tipoRepository;
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
public class Alm_tipoService {
    
    private final Alm_tipoRepository alm_tipoRepository;
    private final Alm_tipoMapper alm_tipoMapper;

    public Alm_tipoService(Alm_tipoRepository alm_tipoRepository, AdministracionUsuariosRepository usuarioRepository, Alm_tipoMapper alm_tipoMapper) {
        this.alm_tipoRepository = alm_tipoRepository;
        this.alm_tipoMapper = alm_tipoMapper;
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

    public Page<Alm_tipoDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_tipoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_tipo> alm_tiposPage = alm_tipoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_tiposPage.map(alm_tipoMapper::toDto);
    }

    public Optional<Alm_tipoDTO> findById(Long id) {
        return alm_tipoRepository.findById(id)
                                     .map(alm_tipoMapper::toDto);
    }

    public Alm_tipoDTO save(Alm_tipoDTO alm_tipoDTO) {
        Alm_tipo alm_tipo = alm_tipoMapper.toEntity(alm_tipoDTO);
        Alm_tipo savedAlm_tipo = alm_tipoRepository.save(alm_tipo);
        return alm_tipoMapper.toDto(savedAlm_tipo);
    }

    public Alm_tipoDTO update(Long id, Alm_tipoDTO alm_tipoDTO) {
        Alm_tipo existingAlm_tipo = alm_tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_tipo no encontrada"));

        alm_tipoMapper.updateFromDto(alm_tipoDTO, existingAlm_tipo);

        Alm_tipo updatedAlm_tipo = alm_tipoRepository.save(existingAlm_tipo);
        return alm_tipoMapper.toDto(updatedAlm_tipo);
    }

    public void deleteById(Long id) {
        alm_tipoRepository.deleteById(id);
    }
}