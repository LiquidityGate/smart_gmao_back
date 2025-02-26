package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_partidaDTO;
import com.gmao.gmao_backend.mapper.Alm_partidaMapper;
import com.gmao.gmao_backend.model.Alm_partida;
import com.gmao.gmao_backend.repository.Alm_partidaRepository;
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
public class Alm_partidaService {
    
    private final Alm_partidaRepository alm_partidaRepository;
    private final Alm_partidaMapper alm_partidaMapper;

    public Alm_partidaService(Alm_partidaRepository alm_partidaRepository, AdministracionUsuariosRepository usuarioRepository, Alm_partidaMapper alm_partidaMapper) {
        this.alm_partidaRepository = alm_partidaRepository;
        this.alm_partidaMapper = alm_partidaMapper;
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

    public Page<Alm_partidaDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_partidaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_partida> alm_partidasPage = alm_partidaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_partidasPage.map(alm_partidaMapper::toDto);
    }

    public Optional<Alm_partidaDTO> findById(Long id) {
        return alm_partidaRepository.findById(id)
                                     .map(alm_partidaMapper::toDto);
    }

    public Alm_partidaDTO save(Alm_partidaDTO alm_partidaDTO) {
        Alm_partida alm_partida = alm_partidaMapper.toEntity(alm_partidaDTO);
        Alm_partida savedAlm_partida = alm_partidaRepository.save(alm_partida);
        return alm_partidaMapper.toDto(savedAlm_partida);
    }

    public Alm_partidaDTO update(Long id, Alm_partidaDTO alm_partidaDTO) {
        Alm_partida existingAlm_partida = alm_partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_partida no encontrada"));

        alm_partidaMapper.updateFromDto(alm_partidaDTO, existingAlm_partida);

        Alm_partida updatedAlm_partida = alm_partidaRepository.save(existingAlm_partida);
        return alm_partidaMapper.toDto(updatedAlm_partida);
    }

    public void deleteById(Long id) {
        alm_partidaRepository.deleteById(id);
    }
}