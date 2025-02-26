package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_subtipoDTO;
import com.gmao.gmao_backend.mapper.Alm_subtipoMapper;
import com.gmao.gmao_backend.model.Alm_subtipo;
import com.gmao.gmao_backend.repository.Alm_subtipoRepository;
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
public class Alm_subtipoService {
    
    private final Alm_subtipoRepository alm_subtipoRepository;
    private final Alm_subtipoMapper alm_subtipoMapper;

    public Alm_subtipoService(Alm_subtipoRepository alm_subtipoRepository, AdministracionUsuariosRepository usuarioRepository, Alm_subtipoMapper alm_subtipoMapper) {
        this.alm_subtipoRepository = alm_subtipoRepository;
        this.alm_subtipoMapper = alm_subtipoMapper;
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

    public Page<Alm_subtipoDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_subtipoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_subtipo> alm_subtiposPage = alm_subtipoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_subtiposPage.map(alm_subtipoMapper::toDto);
    }

    public Optional<Alm_subtipoDTO> findById(Long id) {
        return alm_subtipoRepository.findById(id)
                                     .map(alm_subtipoMapper::toDto);
    }

    public Alm_subtipoDTO save(Alm_subtipoDTO alm_subtipoDTO) {
        Alm_subtipo alm_subtipo = alm_subtipoMapper.toEntity(alm_subtipoDTO);
        Alm_subtipo savedAlm_subtipo = alm_subtipoRepository.save(alm_subtipo);
        return alm_subtipoMapper.toDto(savedAlm_subtipo);
    }

    public Alm_subtipoDTO update(Long id, Alm_subtipoDTO alm_subtipoDTO) {
        Alm_subtipo existingAlm_subtipo = alm_subtipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_subtipo no encontrada"));

        alm_subtipoMapper.updateFromDto(alm_subtipoDTO, existingAlm_subtipo);

        Alm_subtipo updatedAlm_subtipo = alm_subtipoRepository.save(existingAlm_subtipo);
        return alm_subtipoMapper.toDto(updatedAlm_subtipo);
    }

    public void deleteById(Long id) {
        alm_subtipoRepository.deleteById(id);
    }
}