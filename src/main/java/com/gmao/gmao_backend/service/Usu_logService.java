package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_logDTO;
import com.gmao.gmao_backend.mapper.Usu_logMapper;
import com.gmao.gmao_backend.model.Usu_log;
import com.gmao.gmao_backend.repository.Usu_logRepository;
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
public class Usu_logService {
    
    private final Usu_logRepository usu_logRepository;
    private final Usu_logMapper usu_logMapper;

    public Usu_logService(Usu_logRepository usu_logRepository, AdministracionUsuariosRepository usuarioRepository, Usu_logMapper usu_logMapper) {
        this.usu_logRepository = usu_logRepository;
        this.usu_logMapper = usu_logMapper;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    
    public Page<Usu_logDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_logDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_log> usu_logsPage = usu_logRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filterDTO != null) {
                validateNullFilters(predicates, criteriaBuilder, root.get("usuario"), filterDTO.getUsuario());
                validateNullFilters(predicates, criteriaBuilder, root.get("nombres"), filterDTO.getNombres());
                validateNullFilters(predicates, criteriaBuilder, root.get("apellidos"), filterDTO.getApellidos());
                validateNullFilters(predicates, criteriaBuilder, root.get("fecha_ult_conexion"), filterDTO.getFecha_ult_conexion());
                
                if (filterDTO.getNro() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("nro"), filterDTO.getNro()));
                }
            }

            return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_logsPage.map(usu_logMapper::toDto);
    }

    public Optional<Usu_logDTO> findById(Long id) {
        return usu_logRepository.findById(id)
                                     .map(usu_logMapper::toDto);
    }

    public Usu_logDTO save(Usu_logDTO usu_logDTO) {
        Usu_log usu_log = usu_logMapper.toEntity(usu_logDTO);
        Usu_log savedUsu_log = usu_logRepository.save(usu_log);
        return usu_logMapper.toDto(savedUsu_log);
    }

    public Usu_logDTO update(Long id, Usu_logDTO usu_logDTO) {
        Usu_log existingUsu_log = usu_logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_log no encontrada"));

        usu_logMapper.updateFromDto(usu_logDTO, existingUsu_log);

        Usu_log updatedUsu_log = usu_logRepository.save(existingUsu_log);
        return usu_logMapper.toDto(updatedUsu_log);
    }

    public void deleteById(Long id) {
        usu_logRepository.deleteById(id);
    }
}