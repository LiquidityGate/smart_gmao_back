package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_tipo_ingreso_salidaDTO;
import com.gmao.gmao_backend.mapper.Alm_tipo_ingreso_salidaMapper;
import com.gmao.gmao_backend.model.Alm_tipo_ingreso_salida;
import com.gmao.gmao_backend.repository.Alm_tipo_ingreso_salidaRepository;
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
public class Alm_tipo_ingreso_salidaService {
    
    private final Alm_tipo_ingreso_salidaRepository alm_tipo_ingreso_salidaRepository;
    private final Alm_tipo_ingreso_salidaMapper alm_tipo_ingreso_salidaMapper;

    public Alm_tipo_ingreso_salidaService(Alm_tipo_ingreso_salidaRepository alm_tipo_ingreso_salidaRepository, AdministracionUsuariosRepository usuarioRepository, Alm_tipo_ingreso_salidaMapper alm_tipo_ingreso_salidaMapper) {
        this.alm_tipo_ingreso_salidaRepository = alm_tipo_ingreso_salidaRepository;
        this.alm_tipo_ingreso_salidaMapper = alm_tipo_ingreso_salidaMapper;
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

    public Page<Alm_tipo_ingreso_salidaDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_tipo_ingreso_salidaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_tipo_ingreso_salida> alm_tipo_ingreso_salidasPage = alm_tipo_ingreso_salidaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_tipo_ingreso_salidasPage.map(alm_tipo_ingreso_salidaMapper::toDto);
    }

    public Optional<Alm_tipo_ingreso_salidaDTO> findById(Long id) {
        return alm_tipo_ingreso_salidaRepository.findById(id)
                                     .map(alm_tipo_ingreso_salidaMapper::toDto);
    }

    public Alm_tipo_ingreso_salidaDTO save(Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO) {
        Alm_tipo_ingreso_salida alm_tipo_ingreso_salida = alm_tipo_ingreso_salidaMapper.toEntity(alm_tipo_ingreso_salidaDTO);
        Alm_tipo_ingreso_salida savedAlm_tipo_ingreso_salida = alm_tipo_ingreso_salidaRepository.save(alm_tipo_ingreso_salida);
        return alm_tipo_ingreso_salidaMapper.toDto(savedAlm_tipo_ingreso_salida);
    }

    public Alm_tipo_ingreso_salidaDTO update(Long id, Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO) {
        Alm_tipo_ingreso_salida existingAlm_tipo_ingreso_salida = alm_tipo_ingreso_salidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_tipo_ingreso_salida no encontrada"));

        alm_tipo_ingreso_salidaMapper.updateFromDto(alm_tipo_ingreso_salidaDTO, existingAlm_tipo_ingreso_salida);

        Alm_tipo_ingreso_salida updatedAlm_tipo_ingreso_salida = alm_tipo_ingreso_salidaRepository.save(existingAlm_tipo_ingreso_salida);
        return alm_tipo_ingreso_salidaMapper.toDto(updatedAlm_tipo_ingreso_salida);
    }

    public void deleteById(Long id) {
        alm_tipo_ingreso_salidaRepository.deleteById(id);
    }
}