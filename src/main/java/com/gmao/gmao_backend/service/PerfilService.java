package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.PerfilDTO;
import com.gmao.gmao_backend.model.Perfil;
import com.gmao.gmao_backend.repository.PerfilRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
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
public class PerfilService {

    @Autowired
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field,
            String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Obtener todas las órdenes de trabajo
    public Page<Perfil> findAll(int page, int size, String sortField, String sortDirection,
            PerfilDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        return perfilRepository.findAll((root, query, criteriaBuilder) -> {
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
    public Optional<Perfil> findById(Long id) {
        return perfilRepository.findById(id);
    }

    // Crear una nueva orden de trabajo
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Actualizar una orden de trabajo existente
    public Perfil update(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        perfilRepository.deleteById(id);
    }
}