package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_turnoDTO;
import com.gmao.gmao_backend.mapper.Usu_turnoMapper;
import com.gmao.gmao_backend.model.Usu_turno;
import com.gmao.gmao_backend.repository.Usu_turnoRepository;
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
public class Usu_turnoService {
    
    private final Usu_turnoRepository usu_turnoRepository;
    private final Usu_turnoMapper usu_turnoMapper;

    public Usu_turnoService(Usu_turnoRepository usu_turnoRepository, AdministracionUsuariosRepository usuarioRepository, Usu_turnoMapper usu_turnoMapper) {
        this.usu_turnoRepository = usu_turnoRepository;
        this.usu_turnoMapper = usu_turnoMapper;
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

    public Page<Usu_turnoDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_turnoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_turno> usu_turnosPage = usu_turnoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("turno"), filterDTO.getTurno());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_turnosPage.map(usu_turnoMapper::toDto);
    }

    public Optional<Usu_turnoDTO> findById(Long id) {
        return usu_turnoRepository.findById(id)
                                     .map(usu_turnoMapper::toDto);
    }

    public Usu_turnoDTO save(Usu_turnoDTO usu_turnoDTO) {
        Usu_turno usu_turno = usu_turnoMapper.toEntity(usu_turnoDTO);
        Usu_turno savedUsu_turno = usu_turnoRepository.save(usu_turno);
        return usu_turnoMapper.toDto(savedUsu_turno);
    }

    public Usu_turnoDTO update(Long id, Usu_turnoDTO usu_turnoDTO) {
        Usu_turno existingUsu_turno = usu_turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_turno no encontrada"));

        usu_turnoMapper.updateFromDto(usu_turnoDTO, existingUsu_turno);

        Usu_turno updatedUsu_turno = usu_turnoRepository.save(existingUsu_turno);
        return usu_turnoMapper.toDto(updatedUsu_turno);
    }

    public void deleteById(Long id) {
        usu_turnoRepository.deleteById(id);
    }
}