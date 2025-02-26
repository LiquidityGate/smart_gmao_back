package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.OrdenCompraDTO;
import com.gmao.gmao_backend.mapper.OrdenCompraMapper;
import com.gmao.gmao_backend.model.OrdenCompra;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.OrdenCompraRepository;
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
public class OrdenCompraService {
    
    private final OrdenCompraRepository ordenCompraRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final OrdenCompraMapper ordenCompraMapper;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository, AdministracionUsuariosRepository usuarioRepository, OrdenCompraMapper ordenCompraMapper) {
        this.ordenCompraRepository = ordenCompraRepository;
        this.usuarioRepository = usuarioRepository;
        this.ordenCompraMapper = ordenCompraMapper;
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
    public Page<OrdenCompraDTO> findAll(int page, int size, String sortField, String sortDirection, OrdenCompraDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<OrdenCompra> ordenComprasPage = ordenCompraRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            //predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return ordenComprasPage.map(ordenCompraMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<OrdenCompraDTO> findById(Long id) {
        return ordenCompraRepository.findById(id)
                                     .map(ordenCompraMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public OrdenCompraDTO save(OrdenCompraDTO ordenCompraDTO) {
        /* AdministracionUsuarios solicitante = usuarioRepository.findById(ordenCompraDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado")); */
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        OrdenCompra ordenCompra = ordenCompraMapper.toEntity(ordenCompraDTO);
        //ordenCompra.setSolicitante(solicitante);
    
        OrdenCompra savedOrdenCompra = ordenCompraRepository.save(ordenCompra);
        return ordenCompraMapper.toDto(savedOrdenCompra);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public OrdenCompraDTO update(Long id, OrdenCompraDTO ordenCompraDTO) {
        OrdenCompra existingOrdenCompra = ordenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrdenCompra no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        /* if (ordenCompraDTO.getSolicitanteId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(ordenCompraDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingOrdenCompra.setSolicitante(solicitante);
        } */

        // Utiliza MapStruct para actualizar solo los valores no nulos
        ordenCompraMapper.updateFromDto(ordenCompraDTO, existingOrdenCompra);

        // Guarda la entidad actualizada
        OrdenCompra updatedOrdenCompra = ordenCompraRepository.save(existingOrdenCompra);
        return ordenCompraMapper.toDto(updatedOrdenCompra);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        ordenCompraRepository.deleteById(id);
    }
}