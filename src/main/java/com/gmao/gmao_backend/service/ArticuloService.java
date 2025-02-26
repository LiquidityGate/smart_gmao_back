package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.ArticuloDTO;
import com.gmao.gmao_backend.mapper.ArticuloMapper;
import com.gmao.gmao_backend.model.Articulo;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.ArticuloRepository;
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
public class ArticuloService {
    
    private final ArticuloRepository articuloRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final ArticuloMapper articuloMapper;

    public ArticuloService(ArticuloRepository articuloRepository, AdministracionUsuariosRepository usuarioRepository, ArticuloMapper articuloMapper) {
        this.articuloRepository = articuloRepository;
        this.usuarioRepository = usuarioRepository;
        this.articuloMapper = articuloMapper;
    }

    // Método para validar filtros de tipo String
    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Método para validar filtros de tipo Long (para IDs)
    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field, Long value) {
        if (value != null ) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las órdenes de trabajo con filtros y paginación
    public Page<ArticuloDTO> findAll(int page, int size, String sortField, String sortDirection, ArticuloDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Articulo> articulosPage = articuloRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("id_familias"), filterDTO.getId_familias());
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre_art"), filterDTO.getNombre_art());

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            //predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return articulosPage.map(articuloMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<ArticuloDTO> findById(Long id) {
        return articuloRepository.findById(id)
                                     .map(articuloMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public ArticuloDTO save(ArticuloDTO articuloDTO) {
        /* AdministracionUsuarios solicitante = usuarioRepository.findById(articuloDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado")); */
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Articulo articulo = articuloMapper.toEntity(articuloDTO);
        //articulo.setSolicitante(solicitante);
    
        Articulo savedArticulo = articuloRepository.save(articulo);
        return articuloMapper.toDto(savedArticulo);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public ArticuloDTO update(Long id, ArticuloDTO articuloDTO) {
        Articulo existingArticulo = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));

        // Actualizar el solicitante si está presente en el DTO
        /* if (articuloDTO.getSolicitanteId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(articuloDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingArticulo.setSolicitante(solicitante);
        } */

        // Utiliza MapStruct para actualizar solo los valores no nulos
        articuloMapper.updateFromDto(articuloDTO, existingArticulo);

        // Guarda la entidad actualizada
        Articulo updatedArticulo = articuloRepository.save(existingArticulo);
        return articuloMapper.toDto(updatedArticulo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        articuloRepository.deleteById(id);
    }
}