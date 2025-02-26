package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_proveedorDTO;
import com.gmao.gmao_backend.mapper.Alm_proveedorMapper;
import com.gmao.gmao_backend.model.Alm_proveedor;
import com.gmao.gmao_backend.repository.Alm_proveedorRepository;
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
public class Alm_proveedorService {
    
    private final Alm_proveedorRepository alm_proveedorRepository;
    private final Alm_proveedorMapper alm_proveedorMapper;

    public Alm_proveedorService(Alm_proveedorRepository alm_proveedorRepository, AdministracionUsuariosRepository usuarioRepository, Alm_proveedorMapper alm_proveedorMapper) {
        this.alm_proveedorRepository = alm_proveedorRepository;
        this.alm_proveedorMapper = alm_proveedorMapper;
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

    public Page<Alm_proveedorDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_proveedorDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_proveedor> alm_proveedorsPage = alm_proveedorRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("ruc"), filterDTO.getRuc());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_proveedorsPage.map(alm_proveedorMapper::toDto);
    }

    public Optional<Alm_proveedorDTO> findById(Long id) {
        return alm_proveedorRepository.findById(id)
                                     .map(alm_proveedorMapper::toDto);
    }

    public Alm_proveedorDTO save(Alm_proveedorDTO alm_proveedorDTO) {
        Alm_proveedor alm_proveedor = alm_proveedorMapper.toEntity(alm_proveedorDTO);
        Alm_proveedor savedAlm_proveedor = alm_proveedorRepository.save(alm_proveedor);
        return alm_proveedorMapper.toDto(savedAlm_proveedor);
    }

    public Alm_proveedorDTO update(Long id, Alm_proveedorDTO alm_proveedorDTO) {
        Alm_proveedor existingAlm_proveedor = alm_proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_proveedor no encontrada"));

        alm_proveedorMapper.updateFromDto(alm_proveedorDTO, existingAlm_proveedor);

        Alm_proveedor updatedAlm_proveedor = alm_proveedorRepository.save(existingAlm_proveedor);
        return alm_proveedorMapper.toDto(updatedAlm_proveedor);
    }

    public void deleteById(Long id) {
        alm_proveedorRepository.deleteById(id);
    }
}