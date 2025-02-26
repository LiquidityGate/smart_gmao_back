package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.ListaSubtipoDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.mapper.AdministracionUsuariosMapper;
import com.gmao.gmao_backend.mapper.UsuarioSubtipoMapper;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import com.gmao.gmao_backend.repository.UsuarioSubtipoRepository;

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
public class SubtipoService {

    @Autowired
    private final UsuarioSubtipoRepository subtipoRepository;

    private final UsuarioSubtipoMapper subtipoMapper;

    public SubtipoService(UsuarioSubtipoRepository subtipoRepository,
            UsuarioSubtipoMapper subtipoMapper) {
        this.subtipoRepository = subtipoRepository;
        this.subtipoMapper = subtipoMapper;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field,
            String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Obtener todas las órdenes de trabajo
    public Page<UsuarioSubtipo> findAll(int page, int size, String sortField, String sortDirection,
            ListaSubtipoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        return subtipoRepository.findAll((root, query, criteriaBuilder) -> {
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
    public Optional<UsuarioSubtipo> findById(Long id) {
        return subtipoRepository.findById(id);
    }

    // Crear una nueva orden de trabajo
    public UsuarioSubtipo save(UsuarioSubtipo subtipo) {
        return subtipoRepository.save(subtipo);
    }

    // Actualizar una orden de trabajo existente
    public UsuarioSubtipo update(UsuarioSubtipo subtipo) {
        return subtipoRepository.save(subtipo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        subtipoRepository.deleteById(id);
    }

    // Método para obtener solo los campos necesarios para el select box
    public List<ListaSubtipoDTO> findAllForSelect() {
        return subtipoRepository.findAll().stream()
                .map(subtipoMapper::toDto)
                .collect(Collectors.toList());
    }
}