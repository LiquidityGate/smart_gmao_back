package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_cargoDTO;
import com.gmao.gmao_backend.mapper.Usu_cargoMapper;
import com.gmao.gmao_backend.model.Usu_cargo;
import com.gmao.gmao_backend.repository.Usu_cargoRepository;
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
public class Usu_cargoService {
    
    private final Usu_cargoRepository usu_cargoRepository;
    private final Usu_cargoMapper usu_cargoMapper;

    public Usu_cargoService(Usu_cargoRepository usu_cargoRepository, AdministracionUsuariosRepository usuarioRepository, Usu_cargoMapper usu_cargoMapper) {
        this.usu_cargoRepository = usu_cargoRepository;
        this.usu_cargoMapper = usu_cargoMapper;
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

    public Page<Usu_cargoDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_cargoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_cargo> usu_cargosPage = usu_cargoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_cargosPage.map(usu_cargoMapper::toDto);
    }

    public Optional<Usu_cargoDTO> findById(Long id) {
        return usu_cargoRepository.findById(id)
                                     .map(usu_cargoMapper::toDto);
    }

    public Usu_cargoDTO save(Usu_cargoDTO usu_cargoDTO) {
        Usu_cargo usu_cargo = usu_cargoMapper.toEntity(usu_cargoDTO);
        Usu_cargo savedUsu_cargo = usu_cargoRepository.save(usu_cargo);
        return usu_cargoMapper.toDto(savedUsu_cargo);
    }

    public Usu_cargoDTO update(Long id, Usu_cargoDTO usu_cargoDTO) {
        Usu_cargo existingUsu_cargo = usu_cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_cargo no encontrada"));

        usu_cargoMapper.updateFromDto(usu_cargoDTO, existingUsu_cargo);

        Usu_cargo updatedUsu_cargo = usu_cargoRepository.save(existingUsu_cargo);
        return usu_cargoMapper.toDto(updatedUsu_cargo);
    }

    public void deleteById(Long id) {
        usu_cargoRepository.deleteById(id);
    }
}