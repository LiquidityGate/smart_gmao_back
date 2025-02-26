package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_logDTO;
import com.gmao.gmao_backend.mapper.Alm_logMapper;
import com.gmao.gmao_backend.model.Alm_log;
import com.gmao.gmao_backend.repository.Alm_logRepository;
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
public class Alm_logService {
    
    private final Alm_logRepository alm_logRepository;
    private final Alm_logMapper alm_logMapper;

    public Alm_logService(Alm_logRepository alm_logRepository, AdministracionUsuariosRepository usuarioRepository, Alm_logMapper alm_logMapper) {
        this.alm_logRepository = alm_logRepository;
        this.alm_logMapper = alm_logMapper;
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

    public Page<Alm_logDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_logDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_log> alm_logsPage = alm_logRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("articulo"), filterDTO.getArticulo());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_logsPage.map(alm_logMapper::toDto);
    }

    public Optional<Alm_logDTO> findById(Long id) {
        return alm_logRepository.findById(id)
                                     .map(alm_logMapper::toDto);
    }

    public Alm_logDTO save(Alm_logDTO alm_logDTO) {
        Alm_log alm_log = alm_logMapper.toEntity(alm_logDTO);
        Alm_log savedAlm_log = alm_logRepository.save(alm_log);
        return alm_logMapper.toDto(savedAlm_log);
    }

    public Alm_logDTO update(Long id, Alm_logDTO alm_logDTO) {
        Alm_log existingAlm_log = alm_logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_log no encontrada"));

        alm_logMapper.updateFromDto(alm_logDTO, existingAlm_log);

        Alm_log updatedAlm_log = alm_logRepository.save(existingAlm_log);
        return alm_logMapper.toDto(updatedAlm_log);
    }

    public void deleteById(Long id) {
        alm_logRepository.deleteById(id);
    }
}