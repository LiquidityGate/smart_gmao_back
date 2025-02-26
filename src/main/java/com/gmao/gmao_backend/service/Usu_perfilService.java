package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_perfilDTO;
import com.gmao.gmao_backend.mapper.Usu_perfilMapper;
import com.gmao.gmao_backend.model.Usu_perfil;
import com.gmao.gmao_backend.repository.Usu_perfilRepository;
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
public class Usu_perfilService {
    
    private final Usu_perfilRepository usu_perfilRepository;
    private final Usu_perfilMapper usu_perfilMapper;

    public Usu_perfilService(Usu_perfilRepository usu_perfilRepository, AdministracionUsuariosRepository usuarioRepository, Usu_perfilMapper usu_perfilMapper) {
        this.usu_perfilRepository = usu_perfilRepository;
        this.usu_perfilMapper = usu_perfilMapper;
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

    public Page<Usu_perfilDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_perfilDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_perfil> usu_perfilsPage = usu_perfilRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_perfilsPage.map(usu_perfilMapper::toDto);
    }

    public Optional<Usu_perfilDTO> findById(Long id) {
        return usu_perfilRepository.findById(id)
                                     .map(usu_perfilMapper::toDto);
    }

    public Usu_perfilDTO save(Usu_perfilDTO usu_perfilDTO) {
        Usu_perfil usu_perfil = usu_perfilMapper.toEntity(usu_perfilDTO);
        Usu_perfil savedUsu_perfil = usu_perfilRepository.save(usu_perfil);
        return usu_perfilMapper.toDto(savedUsu_perfil);
    }

    public Usu_perfilDTO update(Long id, Usu_perfilDTO usu_perfilDTO) {
        Usu_perfil existingUsu_perfil = usu_perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_perfil no encontrada"));

        usu_perfilMapper.updateFromDto(usu_perfilDTO, existingUsu_perfil);

        Usu_perfil updatedUsu_perfil = usu_perfilRepository.save(existingUsu_perfil);
        return usu_perfilMapper.toDto(updatedUsu_perfil);
    }

    public void deleteById(Long id) {
        usu_perfilRepository.deleteById(id);
    }
}