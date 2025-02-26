package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_condicion_pagoDTO;
import com.gmao.gmao_backend.mapper.Alm_condicion_pagoMapper;
import com.gmao.gmao_backend.model.Alm_condicion_pago;
import com.gmao.gmao_backend.repository.Alm_condicion_pagoRepository;
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
public class Alm_condicion_pagoService {
    
    private final Alm_condicion_pagoRepository alm_condicion_pagoRepository;
    private final Alm_condicion_pagoMapper alm_condicion_pagoMapper;

    public Alm_condicion_pagoService(Alm_condicion_pagoRepository alm_condicion_pagoRepository, AdministracionUsuariosRepository usuarioRepository, Alm_condicion_pagoMapper alm_condicion_pagoMapper) {
        this.alm_condicion_pagoRepository = alm_condicion_pagoRepository;
        this.alm_condicion_pagoMapper = alm_condicion_pagoMapper;
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

    public Page<Alm_condicion_pagoDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_condicion_pagoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_condicion_pago> alm_condicion_pagosPage = alm_condicion_pagoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_condicion_pagosPage.map(alm_condicion_pagoMapper::toDto);
    }

    public Optional<Alm_condicion_pagoDTO> findById(Long id) {
        return alm_condicion_pagoRepository.findById(id)
                                     .map(alm_condicion_pagoMapper::toDto);
    }

    public Alm_condicion_pagoDTO save(Alm_condicion_pagoDTO alm_condicion_pagoDTO) {
        Alm_condicion_pago alm_condicion_pago = alm_condicion_pagoMapper.toEntity(alm_condicion_pagoDTO);
        Alm_condicion_pago savedAlm_condicion_pago = alm_condicion_pagoRepository.save(alm_condicion_pago);
        return alm_condicion_pagoMapper.toDto(savedAlm_condicion_pago);
    }

    public Alm_condicion_pagoDTO update(Long id, Alm_condicion_pagoDTO alm_condicion_pagoDTO) {
        Alm_condicion_pago existingAlm_condicion_pago = alm_condicion_pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_condicion_pago no encontrada"));

        alm_condicion_pagoMapper.updateFromDto(alm_condicion_pagoDTO, existingAlm_condicion_pago);

        Alm_condicion_pago updatedAlm_condicion_pago = alm_condicion_pagoRepository.save(existingAlm_condicion_pago);
        return alm_condicion_pagoMapper.toDto(updatedAlm_condicion_pago);
    }

    public void deleteById(Long id) {
        alm_condicion_pagoRepository.deleteById(id);
    }
}