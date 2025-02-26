package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_asignacionDTO;
import com.gmao.gmao_backend.mapper.Usu_asignacionMapper;
import com.gmao.gmao_backend.model.Usu_asignacion;
import com.gmao.gmao_backend.repository.Usu_asignacionRepository;
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
public class Usu_asignacionService {
    
    private final Usu_asignacionRepository usu_asignacionRepository;
    private final Usu_asignacionMapper usu_asignacionMapper;

    public Usu_asignacionService(Usu_asignacionRepository usu_asignacionRepository, AdministracionUsuariosRepository usuarioRepository, Usu_asignacionMapper usu_asignacionMapper) {
        this.usu_asignacionRepository = usu_asignacionRepository;
        this.usu_asignacionMapper = usu_asignacionMapper;
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

    public Page<Usu_asignacionDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_asignacionDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_asignacion> usu_asignacionsPage = usu_asignacionRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_asignacionsPage.map(usu_asignacionMapper::toDto);
    }

    public Optional<Usu_asignacionDTO> findById(Long id) {
        return usu_asignacionRepository.findById(id)
                                     .map(usu_asignacionMapper::toDto);
    }

    public Usu_asignacionDTO save(Usu_asignacionDTO usu_asignacionDTO) {
        Usu_asignacion usu_asignacion = usu_asignacionMapper.toEntity(usu_asignacionDTO);
        Usu_asignacion savedUsu_asignacion = usu_asignacionRepository.save(usu_asignacion);
        return usu_asignacionMapper.toDto(savedUsu_asignacion);
    }

    public Usu_asignacionDTO update(Long id, Usu_asignacionDTO usu_asignacionDTO) {
        Usu_asignacion existingUsu_asignacion = usu_asignacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_asignacion no encontrada"));

        usu_asignacionMapper.updateFromDto(usu_asignacionDTO, existingUsu_asignacion);

        Usu_asignacion updatedUsu_asignacion = usu_asignacionRepository.save(existingUsu_asignacion);
        return usu_asignacionMapper.toDto(updatedUsu_asignacion);
    }

    public void deleteById(Long id) {
        usu_asignacionRepository.deleteById(id);
    }
}