package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.ListaTiposIdentidadDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.mapper.AdministracionUsuariosMapper;
import com.gmao.gmao_backend.mapper.UsuarioTipoIdentidadMapper;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;
import com.gmao.gmao_backend.repository.UsuarioTipoIdentidadRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

@Service
public class TipoIdentidadService {

    @Autowired
    private final UsuarioTipoIdentidadRepository tipoIdentidadRepository;

    private final UsuarioTipoIdentidadMapper tipoIdentidadMapper;

    public TipoIdentidadService(UsuarioTipoIdentidadRepository tipoIdentidadRepository,
            UsuarioTipoIdentidadMapper tipoIdentidadMapper) {
        this.tipoIdentidadRepository = tipoIdentidadRepository;
        this.tipoIdentidadMapper = tipoIdentidadMapper;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field,
            String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Obtener todas las órdenes de trabajo
    public Page<UsuarioTiposIdentidad> findAll(int page, int size, String sortField, String sortDirection,
            ListaTiposIdentidadDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        return tipoIdentidadRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            // predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            // Si no hay filtros, devolver todos los resultados
            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction(); // Esto equivale a no aplicar ningún filtro
            }

            // Otros filtros que quieras agregar
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    // Obtener una orden de trabajo por ID
    public Optional<UsuarioTiposIdentidad> findById(Long id) {
        return tipoIdentidadRepository.findById(id);
    }

    // Crear una nueva orden de trabajo
    public UsuarioTiposIdentidad save(UsuarioTiposIdentidad tipoIdentidad) {
        return tipoIdentidadRepository.save(tipoIdentidad);
    }

    // Actualizar una orden de trabajo existente
    public UsuarioTiposIdentidad update(UsuarioTiposIdentidad tipoIdentidad) {
        return tipoIdentidadRepository.save(tipoIdentidad);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        tipoIdentidadRepository.deleteById(id);
    }

    // Método para obtener solo los campos necesarios para el select box
    public List<ListaTiposIdentidadDTO> findAllForSelect() {
        return tipoIdentidadRepository.findAll().stream()
                .map(tipoIdentidadMapper::toDto)
                .collect(Collectors.toList());
    }
}