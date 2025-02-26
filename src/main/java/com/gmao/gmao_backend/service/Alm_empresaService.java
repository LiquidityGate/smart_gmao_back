package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_empresaDTO;
import com.gmao.gmao_backend.mapper.Alm_empresaMapper;
import com.gmao.gmao_backend.model.Alm_empresa;
import com.gmao.gmao_backend.repository.Alm_empresaRepository;
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
public class Alm_empresaService {
    
    private final Alm_empresaRepository alm_empresaRepository;
    private final Alm_empresaMapper alm_empresaMapper;

    public Alm_empresaService(Alm_empresaRepository alm_empresaRepository, AdministracionUsuariosRepository usuarioRepository, Alm_empresaMapper alm_empresaMapper) {
        this.alm_empresaRepository = alm_empresaRepository;
        this.alm_empresaMapper = alm_empresaMapper;
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

    public Page<Alm_empresaDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_empresaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_empresa> alm_empresasPage = alm_empresaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_empresasPage.map(alm_empresaMapper::toDto);
    }

    public Optional<Alm_empresaDTO> findById(Long id) {
        return alm_empresaRepository.findById(id)
                                     .map(alm_empresaMapper::toDto);
    }

    public Alm_empresaDTO save(Alm_empresaDTO alm_empresaDTO) {
        Alm_empresa alm_empresa = alm_empresaMapper.toEntity(alm_empresaDTO);
        Alm_empresa savedAlm_empresa = alm_empresaRepository.save(alm_empresa);
        return alm_empresaMapper.toDto(savedAlm_empresa);
    }

    public Alm_empresaDTO update(Long id, Alm_empresaDTO alm_empresaDTO) {
        Alm_empresa existingAlm_empresa = alm_empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_empresa no encontrada"));

        alm_empresaMapper.updateFromDto(alm_empresaDTO, existingAlm_empresa);

        Alm_empresa updatedAlm_empresa = alm_empresaRepository.save(existingAlm_empresa);
        return alm_empresaMapper.toDto(updatedAlm_empresa);
    }

    public void deleteById(Long id) {
        alm_empresaRepository.deleteById(id);
    }
}