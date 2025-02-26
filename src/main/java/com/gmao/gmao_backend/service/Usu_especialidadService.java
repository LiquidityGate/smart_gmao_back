package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_especialidadDTO;
import com.gmao.gmao_backend.mapper.Usu_especialidadMapper;
import com.gmao.gmao_backend.model.Usu_especialidad;
import com.gmao.gmao_backend.repository.Usu_especialidadRepository;
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
public class Usu_especialidadService {
    
    private final Usu_especialidadRepository usu_especialidadRepository;
    private final Usu_especialidadMapper usu_especialidadMapper;

    public Usu_especialidadService(Usu_especialidadRepository usu_especialidadRepository, AdministracionUsuariosRepository usuarioRepository, Usu_especialidadMapper usu_especialidadMapper) {
        this.usu_especialidadRepository = usu_especialidadRepository;
        this.usu_especialidadMapper = usu_especialidadMapper;
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

    public Page<Usu_especialidadDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_especialidadDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_especialidad> usu_especialidadsPage = usu_especialidadRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_especialidadsPage.map(usu_especialidadMapper::toDto);
    }

    public Optional<Usu_especialidadDTO> findById(Long id) {
        return usu_especialidadRepository.findById(id)
                                     .map(usu_especialidadMapper::toDto);
    }

    public Usu_especialidadDTO save(Usu_especialidadDTO usu_especialidadDTO) {
        Usu_especialidad usu_especialidad = usu_especialidadMapper.toEntity(usu_especialidadDTO);
        Usu_especialidad savedUsu_especialidad = usu_especialidadRepository.save(usu_especialidad);
        return usu_especialidadMapper.toDto(savedUsu_especialidad);
    }

    public Usu_especialidadDTO update(Long id, Usu_especialidadDTO usu_especialidadDTO) {
        Usu_especialidad existingUsu_especialidad = usu_especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_especialidad no encontrada"));

        usu_especialidadMapper.updateFromDto(usu_especialidadDTO, existingUsu_especialidad);

        Usu_especialidad updatedUsu_especialidad = usu_especialidadRepository.save(existingUsu_especialidad);
        return usu_especialidadMapper.toDto(updatedUsu_especialidad);
    }

    public void deleteById(Long id) {
        usu_especialidadRepository.deleteById(id);
    }
}