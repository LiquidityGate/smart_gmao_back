package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Usu_usuarioDTO;
import com.gmao.gmao_backend.mapper.Usu_usuarioMapper;
import com.gmao.gmao_backend.model.Usu_usuario;
import com.gmao.gmao_backend.repository.Usu_usuarioRepository;
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
public class Usu_usuarioService {
    
    private final Usu_usuarioRepository usu_usuarioRepository;
    private final Usu_usuarioMapper usu_usuarioMapper;

    public Usu_usuarioService(Usu_usuarioRepository usu_usuarioRepository, AdministracionUsuariosRepository usuarioRepository, Usu_usuarioMapper usu_usuarioMapper) {
        this.usu_usuarioRepository = usu_usuarioRepository;
        this.usu_usuarioMapper = usu_usuarioMapper;
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

    public Page<Usu_usuarioDTO> findAll(int page, int size, String sortField, String sortDirection, Usu_usuarioDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Usu_usuario> usu_usuariosPage = usu_usuarioRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return usu_usuariosPage.map(usu_usuarioMapper::toDto);
    }

    public Optional<Usu_usuarioDTO> findById(Long id) {
        return usu_usuarioRepository.findById(id)
                                     .map(usu_usuarioMapper::toDto);
    }

    public Usu_usuarioDTO save(Usu_usuarioDTO usu_usuarioDTO) {
        Usu_usuario usu_usuario = usu_usuarioMapper.toEntity(usu_usuarioDTO);
        Usu_usuario savedUsu_usuario = usu_usuarioRepository.save(usu_usuario);
        return usu_usuarioMapper.toDto(savedUsu_usuario);
    }

    public Usu_usuarioDTO update(Long id, Usu_usuarioDTO usu_usuarioDTO) {
        Usu_usuario existingUsu_usuario = usu_usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usu_usuario no encontrada"));

        usu_usuarioMapper.updateFromDto(usu_usuarioDTO, existingUsu_usuario);

        Usu_usuario updatedUsu_usuario = usu_usuarioRepository.save(existingUsu_usuario);
        return usu_usuarioMapper.toDto(updatedUsu_usuario);
    }

    public void deleteById(Long id) {
        usu_usuarioRepository.deleteById(id);
    }
}