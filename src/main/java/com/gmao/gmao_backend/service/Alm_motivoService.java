package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_motivoDTO;
import com.gmao.gmao_backend.mapper.Alm_motivoMapper;
import com.gmao.gmao_backend.model.Alm_motivo;
import com.gmao.gmao_backend.repository.Alm_motivoRepository;
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
public class Alm_motivoService {
    
    private final Alm_motivoRepository alm_motivoRepository;
    private final Alm_motivoMapper alm_motivoMapper;

    public Alm_motivoService(Alm_motivoRepository alm_motivoRepository, AdministracionUsuariosRepository usuarioRepository, Alm_motivoMapper alm_motivoMapper) {
        this.alm_motivoRepository = alm_motivoRepository;
        this.alm_motivoMapper = alm_motivoMapper;
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

    public Page<Alm_motivoDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_motivoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_motivo> alm_motivosPage = alm_motivoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_motivosPage.map(alm_motivoMapper::toDto);
    }

    public Optional<Alm_motivoDTO> findById(Long id) {
        return alm_motivoRepository.findById(id)
                                     .map(alm_motivoMapper::toDto);
    }

    public Alm_motivoDTO save(Alm_motivoDTO alm_motivoDTO) {
        Alm_motivo alm_motivo = alm_motivoMapper.toEntity(alm_motivoDTO);
        Alm_motivo savedAlm_motivo = alm_motivoRepository.save(alm_motivo);
        return alm_motivoMapper.toDto(savedAlm_motivo);
    }

    public Alm_motivoDTO update(Long id, Alm_motivoDTO alm_motivoDTO) {
        Alm_motivo existingAlm_motivo = alm_motivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_motivo no encontrada"));

        alm_motivoMapper.updateFromDto(alm_motivoDTO, existingAlm_motivo);

        Alm_motivo updatedAlm_motivo = alm_motivoRepository.save(existingAlm_motivo);
        return alm_motivoMapper.toDto(updatedAlm_motivo);
    }

    public void deleteById(Long id) {
        alm_motivoRepository.deleteById(id);
    }
}