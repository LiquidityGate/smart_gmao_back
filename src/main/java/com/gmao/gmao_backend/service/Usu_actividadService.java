package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_actividadDTO;
import com.gmao.gmao_backend.mapper.Usu_actividadMapper;
import com.gmao.gmao_backend.model.Usu_actividad;
import com.gmao.gmao_backend.repository.Usu_actividadRepository;
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
public class Usu_actividadService {
    
    private final Usu_actividadRepository usu_actividadRepository;
    private final Usu_actividadMapper usu_actividadMapper;

    public Usu_actividadService(Usu_actividadRepository usu_actividadRepository, AdministracionUsuariosRepository usuarioRepository, Usu_actividadMapper usu_actividadMapper) {
        this.usu_actividadRepository = usu_actividadRepository;
        this.usu_actividadMapper = usu_actividadMapper;
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

    public Page<Usu_actividadDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_actividadDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_actividad> usu_actividadsPage = usu_actividadRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_actividadsPage.map(usu_actividadMapper::toDto);
    }

    public Optional<Usu_actividadDTO> findById(Long id) {
        return usu_actividadRepository.findById(id)
                                     .map(usu_actividadMapper::toDto);
    }

    public Usu_actividadDTO save(Usu_actividadDTO usu_actividadDTO) {
        Usu_actividad usu_actividad = usu_actividadMapper.toEntity(usu_actividadDTO);
        Usu_actividad savedUsu_actividad = usu_actividadRepository.save(usu_actividad);
        return usu_actividadMapper.toDto(savedUsu_actividad);
    }

    public Usu_actividadDTO update(Long id, Usu_actividadDTO usu_actividadDTO) {
        Usu_actividad existingUsu_actividad = usu_actividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_actividad no encontrada"));

        usu_actividadMapper.updateFromDto(usu_actividadDTO, existingUsu_actividad);

        Usu_actividad updatedUsu_actividad = usu_actividadRepository.save(existingUsu_actividad);
        return usu_actividadMapper.toDto(updatedUsu_actividad);
    }

    public void deleteById(Long id) {
        usu_actividadRepository.deleteById(id);
    }
}