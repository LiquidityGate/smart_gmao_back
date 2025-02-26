package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_feedbackDTO;
import com.gmao.gmao_backend.mapper.Usu_feedbackMapper;
import com.gmao.gmao_backend.model.Usu_feedback;
import com.gmao.gmao_backend.repository.Usu_feedbackRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Usu_feedbackService {
    
    private final Usu_feedbackRepository usu_feedbackRepository;
    private final Usu_feedbackMapper usu_feedbackMapper;

    public Usu_feedbackService(Usu_feedbackRepository usu_feedbackRepository, Usu_feedbackMapper usu_feedbackMapper) {
        this.usu_feedbackRepository = usu_feedbackRepository;
        this.usu_feedbackMapper = usu_feedbackMapper;
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

    public Page<Usu_feedbackDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_feedbackDTO filterDTO) {
        try {
            // Default sort field if none provided
            if (sortField == null || sortField.trim().isEmpty()) {
                sortField = "id";
            }
            
            // Default sort direction if none provided
            if (sortDirection == null || sortDirection.trim().isEmpty()) {
                sortDirection = "DESC";
            }
            
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection.toUpperCase()), sortField));

            Page<Usu_feedback> usu_feedbacksPage = usu_feedbackRepository.findAll((root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (filterDTO != null) {
                    validateNullFilters(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
                    // Add more filters here if needed
                }

                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }, pageable);

            return usu_feedbacksPage.map(usu_feedbackMapper::toDto);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los feedbacks: " + e.getMessage(), e);
        }
    }

    public Optional<Usu_feedbackDTO> findById(Long id) {
        return usu_feedbackRepository.findById(id)
                                     .map(usu_feedbackMapper::toDto);
    }

    public Usu_feedbackDTO save(Usu_feedbackDTO usu_feedbackDTO) {
        Usu_feedback usu_feedback = usu_feedbackMapper.toEntity(usu_feedbackDTO);
        Usu_feedback savedUsu_feedback = usu_feedbackRepository.save(usu_feedback);
        return usu_feedbackMapper.toDto(savedUsu_feedback);
    }

    public Usu_feedbackDTO update(Long id, Usu_feedbackDTO usu_feedbackDTO) {
        Usu_feedback existingUsu_feedback = usu_feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_feedback no encontrada"));

        usu_feedbackMapper.updateFromDto(usu_feedbackDTO, existingUsu_feedback);

        Usu_feedback updatedUsu_feedback = usu_feedbackRepository.save(existingUsu_feedback);
        return usu_feedbackMapper.toDto(updatedUsu_feedback);
    }

    public void deleteById(Long id) {
        usu_feedbackRepository.deleteById(id);
    }
}