package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.SalidaDTO;
import com.gmao.gmao_backend.mapper.SalidaMapper;
import com.gmao.gmao_backend.model.Salida;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.SalidaRepository;
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
public class SalidaService {
    
    private final SalidaRepository salidaRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final SalidaMapper salidaMapper;

    public SalidaService(SalidaRepository salidaRepository, AdministracionUsuariosRepository usuarioRepository, SalidaMapper salidaMapper) {
        this.salidaRepository = salidaRepository;
        this.usuarioRepository = usuarioRepository;
        this.salidaMapper = salidaMapper;
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
    public Page<SalidaDTO> findAll(int page, int size, String sortField, String sortDirection, SalidaDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Salida> salidasPage = salidaRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());

            // Asegurarse de que no se incluyan órdenes con estado "Anulado"
            //predicates.add(criteriaBuilder.notEqual(root.get("estado"), "Anulado"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return salidasPage.map(salidaMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<SalidaDTO> findById(Long id) {
        return salidaRepository.findById(id)
                                     .map(salidaMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public SalidaDTO save(SalidaDTO salidaDTO) {
        /* AdministracionUsuarios solicitante = usuarioRepository.findById(salidaDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado")); */
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Salida salida = salidaMapper.toEntity(salidaDTO);
        //salida.setSolicitante(solicitante);
    
        Salida savedSalida = salidaRepository.save(salida);
        return salidaMapper.toDto(savedSalida);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public SalidaDTO update(Long id, SalidaDTO salidaDTO) {
        Salida existingSalida = salidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salida no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        /* if (salidaDTO.getSolicitanteId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(salidaDTO.getSolicitanteId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingSalida.setSolicitante(solicitante);
        } */

        // Utiliza MapStruct para actualizar solo los valores no nulos
        salidaMapper.updateFromDto(salidaDTO, existingSalida);

        // Guarda la entidad actualizada
        Salida updatedSalida = salidaRepository.save(existingSalida);
        return salidaMapper.toDto(updatedSalida);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        salidaRepository.deleteById(id);
    }
}