package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_almacenDTO;
import com.gmao.gmao_backend.mapper.Alm_almacenMapper;
import com.gmao.gmao_backend.model.Alm_almacen;
import com.gmao.gmao_backend.repository.Alm_almacenRepository;
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
public class Alm_almacenService {
    
    private final Alm_almacenRepository alm_almacenRepository;
    private final Alm_almacenMapper alm_almacenMapper;

    public Alm_almacenService(Alm_almacenRepository alm_almacenRepository, AdministracionUsuariosRepository usuarioRepository, Alm_almacenMapper alm_almacenMapper) {
        this.alm_almacenRepository = alm_almacenRepository;
        this.alm_almacenMapper = alm_almacenMapper;
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

    public Page<Alm_almacenDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_almacenDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_almacen> alm_almacensPage = alm_almacenRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_almacensPage.map(alm_almacenMapper::toDto);
    }

    public Optional<Alm_almacenDTO> findById(Long id) {
        return alm_almacenRepository.findById(id)
                                     .map(alm_almacenMapper::toDto);
    }

    public Alm_almacenDTO save(Alm_almacenDTO alm_almacenDTO) {
        Alm_almacen alm_almacen = alm_almacenMapper.toEntity(alm_almacenDTO);
        Alm_almacen savedAlm_almacen = alm_almacenRepository.save(alm_almacen);
        return alm_almacenMapper.toDto(savedAlm_almacen);
    }

    public Alm_almacenDTO update(Long id, Alm_almacenDTO alm_almacenDTO) {
        Alm_almacen existingAlm_almacen = alm_almacenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_almacen no encontrada"));

        alm_almacenMapper.updateFromDto(alm_almacenDTO, existingAlm_almacen);

        Alm_almacen updatedAlm_almacen = alm_almacenRepository.save(existingAlm_almacen);
        return alm_almacenMapper.toDto(updatedAlm_almacen);
    }

    public void deleteById(Long id) {
        alm_almacenRepository.deleteById(id);
    }
}