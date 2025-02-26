package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_articuloDTO;
import com.gmao.gmao_backend.mapper.Alm_articuloMapper;
import com.gmao.gmao_backend.model.Alm_articulo;
import com.gmao.gmao_backend.repository.Alm_articuloRepository;
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
public class Alm_articuloService {
    
    private final Alm_articuloRepository alm_articuloRepository;
    private final Alm_articuloMapper alm_articuloMapper;

    public Alm_articuloService(Alm_articuloRepository alm_articuloRepository, AdministracionUsuariosRepository usuarioRepository, Alm_articuloMapper alm_articuloMapper) {
        this.alm_articuloRepository = alm_articuloRepository;
        this.alm_articuloMapper = alm_articuloMapper;
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

    public Page<Alm_articuloDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_articuloDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_articulo> alm_articulosPage = alm_articuloRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_articulosPage.map(alm_articuloMapper::toDto);
    }

    public Optional<Alm_articuloDTO> findById(Long id) {
        return alm_articuloRepository.findById(id)
                                     .map(alm_articuloMapper::toDto);
    }

    public Alm_articuloDTO save(Alm_articuloDTO alm_articuloDTO) {
        Alm_articulo alm_articulo = alm_articuloMapper.toEntity(alm_articuloDTO);
        Alm_articulo savedAlm_articulo = alm_articuloRepository.save(alm_articulo);
        return alm_articuloMapper.toDto(savedAlm_articulo);
    }

    public Alm_articuloDTO update(Long id, Alm_articuloDTO alm_articuloDTO) {
        Alm_articulo existingAlm_articulo = alm_articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_articulo no encontrada"));

        alm_articuloMapper.updateFromDto(alm_articuloDTO, existingAlm_articulo);

        Alm_articulo updatedAlm_articulo = alm_articuloRepository.save(existingAlm_articulo);
        return alm_articuloMapper.toDto(updatedAlm_articulo);
    }

    public void deleteById(Long id) {
        alm_articuloRepository.deleteById(id);
    }
}