package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.TipoDTO;
import com.gmao.gmao_backend.mapper.TipoMapper;
import com.gmao.gmao_backend.model.Tipo;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.TipoRepository;
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
public class TipoService {
    
    private final TipoRepository tipoRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final TipoMapper tipoMapper;

    public TipoService(TipoRepository TipoRepository, AdministracionUsuariosRepository usuarioRepository, TipoMapper tipoMapper) {
        this.tipoRepository = TipoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tipoMapper = tipoMapper;
    }

    // Método para validar filtros de tipo String
    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Método para validar filtros de tipo Long (para IDs)
    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, Integer value) {
        if (value != null && value > 0 ) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las órdenes de trabajo con filtros y paginación
    public Page<TipoDTO> findAll(int page, int size, String sortField, String sortDirection, TipoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Tipo> ordenPage = tipoRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateNullFilters(predicates, criteriaBuilder, root.get("estado"), filterDTO.getEstado());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return ordenPage.map(tipoMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<TipoDTO> findById(Long id) {
        return tipoRepository.findById(id)
                                     .map(tipoMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public TipoDTO save(TipoDTO tipoDTO) {
        AdministracionUsuarios solicitante = usuarioRepository.findById(tipoDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Tipo tipo = tipoMapper.toEntity(tipoDTO);
        tipo.setIngresado_por(solicitante);
    
        Tipo savedTipo = tipoRepository.save(tipo);
        return tipoMapper.toDto(savedTipo);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public TipoDTO update(Long id, TipoDTO tipoDTO) {
        Tipo existingTipo = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        if (tipoDTO.getIngresado_porId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(tipoDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingTipo.setIngresado_por(solicitante);
        }

        // Utiliza MapStruct para actualizar solo los valores no nulos
        tipoMapper.updateFromDto(tipoDTO, existingTipo);

        // Guarda la entidad actualizada
        Tipo updatedOrdenTrabajo = tipoRepository.save(existingTipo);
        return tipoMapper.toDto(updatedOrdenTrabajo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        tipoRepository.deleteById(id);
    }
}