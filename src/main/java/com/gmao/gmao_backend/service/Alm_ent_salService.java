package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_ent_salDTO;
import com.gmao.gmao_backend.mapper.Alm_ent_salMapper;
import com.gmao.gmao_backend.model.Alm_ent_sal;
import com.gmao.gmao_backend.repository.Alm_ent_salRepository;
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
public class Alm_ent_salService {
    
    private final Alm_ent_salRepository alm_ent_salRepository;
    private final Alm_ent_salMapper alm_ent_salMapper;

    public Alm_ent_salService(Alm_ent_salRepository alm_ent_salRepository, AdministracionUsuariosRepository usuarioRepository, Alm_ent_salMapper alm_ent_salMapper) {
        this.alm_ent_salRepository = alm_ent_salRepository;
        this.alm_ent_salMapper = alm_ent_salMapper;
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

    public Page<Alm_ent_salDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_ent_salDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_ent_sal> alm_ent_salsPage = alm_ent_salRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("articulo"), filterDTO.getArticulo());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_ent_salsPage.map(alm_ent_salMapper::toDto);
    }

    public Optional<Alm_ent_salDTO> findById(Long id) {
        return alm_ent_salRepository.findById(id)
                                     .map(alm_ent_salMapper::toDto);
    }

    public Alm_ent_salDTO save(Alm_ent_salDTO alm_ent_salDTO) {
        Alm_ent_sal alm_ent_sal = alm_ent_salMapper.toEntity(alm_ent_salDTO);
        Alm_ent_sal savedAlm_ent_sal = alm_ent_salRepository.save(alm_ent_sal);
        return alm_ent_salMapper.toDto(savedAlm_ent_sal);
    }

    public Alm_ent_salDTO update(Long id, Alm_ent_salDTO alm_ent_salDTO) {
        Alm_ent_sal existingAlm_ent_sal = alm_ent_salRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_ent_sal no encontrada"));

        alm_ent_salMapper.updateFromDto(alm_ent_salDTO, existingAlm_ent_sal);

        Alm_ent_sal updatedAlm_ent_sal = alm_ent_salRepository.save(existingAlm_ent_sal);
        return alm_ent_salMapper.toDto(updatedAlm_ent_sal);
    }

    public void deleteById(Long id) {
        alm_ent_salRepository.deleteById(id);
    }
}