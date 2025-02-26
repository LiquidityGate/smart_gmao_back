package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.OrdenTrabajoDTO;
import com.gmao.gmao_backend.mapper.AdministracionUsuariosMapper;
import com.gmao.gmao_backend.mapper.OrdenTrabajoMapper;
import com.gmao.gmao_backend.model.OrdenTrabajo;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.AdministracionUsuariosIDName;
import com.gmao.gmao_backend.repository.OrdenTrabajoRepository;
import com.gmao.gmao_backend.repository.AdministracionUsuariosRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenTrabajoService {
    
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final OrdenTrabajoMapper ordenTrabajoMapper;
    private final AdministracionUsuariosMapper administracionUsuariosMapper;

    public OrdenTrabajoService(OrdenTrabajoRepository ordenTrabajoRepository, AdministracionUsuariosRepository usuarioRepository, OrdenTrabajoMapper ordenTrabajoMapper, AdministracionUsuariosMapper administracionUsuariosMapper) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.usuarioRepository = usuarioRepository;
        this.ordenTrabajoMapper = ordenTrabajoMapper;
        this.administracionUsuariosMapper = administracionUsuariosMapper;
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
    public Page<OrdenTrabajoDTO> findAll(int page, int size, String sortField, String sortDirection, OrdenTrabajoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<OrdenTrabajo> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("numero"), filterDTO.getNumero());
            validateNullFilters(predicates, criteriaBuilder, root.get("descripcion"), filterDTO.getDescripcion());
            validateNullFilters(predicates, criteriaBuilder, root.get("estado"), filterDTO.getEstado());
            validateNullFilters(predicates, criteriaBuilder, root.get("tipo"), filterDTO.getTipo());
            validateNullFilters(predicates, criteriaBuilder, root.get("prioridad"), filterDTO.getPrioridad());
            validateNullFilters(predicates, criteriaBuilder, root.get("sitio"), filterDTO.getSitio());
            validateIdFilters(predicates, criteriaBuilder, root.get("solicitante").get("id"), filterDTO.getSolicitanteId());

            // Excluir órdenes con estado "Anulado"
            predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Realizar la consulta en el repositorio y mapear los resultados a DTO
        Page<OrdenTrabajo> ordenesPage = ordenTrabajoRepository.findAll(spec, pageable);
        return ordenesPage.map(ordenTrabajoMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<OrdenTrabajoDTO> findById(Long id) {
        return ordenTrabajoRepository.findById(id)
                                     .map(ordenTrabajoMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public OrdenTrabajoDTO save(OrdenTrabajoDTO ordenTrabajoDTO) {
        AdministracionUsuarios solicitante = usuarioRepository.findById(ordenTrabajoDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
    
        // Convierte AdministracionUsuarios a AdministracionUsuariosIDName
        AdministracionUsuariosIDName solicitanteParcial = administracionUsuariosMapper.toPartial(solicitante);
    
        // Convierte el DTO a entidad y establece el solicitante parcial manualmente
        OrdenTrabajo ordenTrabajo = ordenTrabajoMapper.toEntity(ordenTrabajoDTO);
        ordenTrabajo.setSolicitante(solicitanteParcial);
    
        OrdenTrabajo savedOrdenTrabajo = ordenTrabajoRepository.save(ordenTrabajo);
        return ordenTrabajoMapper.toDto(savedOrdenTrabajo);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public OrdenTrabajoDTO update(Long id, OrdenTrabajoDTO ordenTrabajoDTO) {
        // Buscar la OrdenTrabajo existente por su ID
        OrdenTrabajo existingOrdenTrabajo = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden de trabajo no encontrada"));
    
        // Actualizar el solicitante si está presente en el DTO
        if (ordenTrabajoDTO.getSolicitanteId() != null) {
            // Buscar el solicitante con el ID proporcionado y mapearlo a AdministracionUsuariosIDName
            AdministracionUsuarios solicitanteEntity = usuarioRepository.findById(ordenTrabajoDTO.getSolicitanteId())
                    .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
    
            AdministracionUsuariosIDName solicitantePartial = administracionUsuariosMapper.toPartial(solicitanteEntity);
            existingOrdenTrabajo.setSolicitante(solicitantePartial);
        }
    
        // Utilizar MapStruct para actualizar solo los valores no nulos del DTO
        ordenTrabajoMapper.updateFromDto(ordenTrabajoDTO, existingOrdenTrabajo);
    
        // Guardar la entidad actualizada
        OrdenTrabajo updatedOrdenTrabajo = ordenTrabajoRepository.save(existingOrdenTrabajo);
    
        // Convertir la entidad actualizada a DTO y retornarla
        return ordenTrabajoMapper.toDto(updatedOrdenTrabajo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        ordenTrabajoRepository.deleteById(id);
    }
}