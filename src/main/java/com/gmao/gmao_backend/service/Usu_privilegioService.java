package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_privilegioDTO;
import com.gmao.gmao_backend.mapper.Usu_privilegioMapper;
import com.gmao.gmao_backend.model.Usu_privilegio;
import com.gmao.gmao_backend.repository.Usu_privilegioRepository;
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
public class Usu_privilegioService {
    
    private final Usu_privilegioRepository usu_privilegioRepository;
    private final Usu_privilegioMapper usu_privilegioMapper;

    public Usu_privilegioService(Usu_privilegioRepository usu_privilegioRepository, AdministracionUsuariosRepository usuarioRepository, Usu_privilegioMapper usu_privilegioMapper) {
        this.usu_privilegioRepository = usu_privilegioRepository;
        this.usu_privilegioMapper = usu_privilegioMapper;
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

    public Page<Usu_privilegioDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_privilegioDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_privilegio> usu_privilegiosPage = usu_privilegioRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_privilegiosPage.map(usu_privilegioMapper::toDto);
    }

    public Optional<Usu_privilegioDTO> findById(Long id) {
        return usu_privilegioRepository.findById(id)
                                     .map(usu_privilegioMapper::toDto);
    }

    public Usu_privilegioDTO save(Usu_privilegioDTO usu_privilegioDTO) {
        Usu_privilegio usu_privilegio = usu_privilegioMapper.toEntity(usu_privilegioDTO);
        Usu_privilegio savedUsu_privilegio = usu_privilegioRepository.save(usu_privilegio);
        return usu_privilegioMapper.toDto(savedUsu_privilegio);
    }

    public Usu_privilegioDTO update(Long id, Usu_privilegioDTO usu_privilegioDTO) {
        Usu_privilegio existingUsu_privilegio = usu_privilegioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_privilegio no encontrada"));

        usu_privilegioMapper.updateFromDto(usu_privilegioDTO, existingUsu_privilegio);

        Usu_privilegio updatedUsu_privilegio = usu_privilegioRepository.save(existingUsu_privilegio);
        return usu_privilegioMapper.toDto(updatedUsu_privilegio);
    }

    public void deleteById(Long id) {
        usu_privilegioRepository.deleteById(id);
    }
}