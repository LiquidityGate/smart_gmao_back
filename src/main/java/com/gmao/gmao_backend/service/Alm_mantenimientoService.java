package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_mantenimientoDTO;
import com.gmao.gmao_backend.mapper.Alm_mantenimientoMapper;
import com.gmao.gmao_backend.model.Alm_mantenimiento;
import com.gmao.gmao_backend.repository.Alm_mantenimientoRepository;
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
public class Alm_mantenimientoService {
    
    private final Alm_mantenimientoRepository alm_mantenimientoRepository;
    private final Alm_mantenimientoMapper alm_mantenimientoMapper;

    public Alm_mantenimientoService(Alm_mantenimientoRepository alm_mantenimientoRepository, AdministracionUsuariosRepository usuarioRepository, Alm_mantenimientoMapper alm_mantenimientoMapper) {
        this.alm_mantenimientoRepository = alm_mantenimientoRepository;
        this.alm_mantenimientoMapper = alm_mantenimientoMapper;
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

    public Page<Alm_mantenimientoDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_mantenimientoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_mantenimiento> alm_mantenimientosPage = alm_mantenimientoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_mantenimientosPage.map(alm_mantenimientoMapper::toDto);
    }

    public Optional<Alm_mantenimientoDTO> findById(Long id) {
        return alm_mantenimientoRepository.findById(id)
                                     .map(alm_mantenimientoMapper::toDto);
    }

    public Alm_mantenimientoDTO save(Alm_mantenimientoDTO alm_mantenimientoDTO) {
        Alm_mantenimiento alm_mantenimiento = alm_mantenimientoMapper.toEntity(alm_mantenimientoDTO);
        Alm_mantenimiento savedAlm_mantenimiento = alm_mantenimientoRepository.save(alm_mantenimiento);
        return alm_mantenimientoMapper.toDto(savedAlm_mantenimiento);
    }

    public Alm_mantenimientoDTO update(Long id, Alm_mantenimientoDTO alm_mantenimientoDTO) {
        Alm_mantenimiento existingAlm_mantenimiento = alm_mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_mantenimiento no encontrada"));

        alm_mantenimientoMapper.updateFromDto(alm_mantenimientoDTO, existingAlm_mantenimiento);

        Alm_mantenimiento updatedAlm_mantenimiento = alm_mantenimientoRepository.save(existingAlm_mantenimiento);
        return alm_mantenimientoMapper.toDto(updatedAlm_mantenimiento);
    }

    public void deleteById(Long id) {
        alm_mantenimientoRepository.deleteById(id);
    }
}