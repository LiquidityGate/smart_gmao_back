package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.MarcasDTO;
import com.gmao.gmao_backend.mapper.MarcasMapper;
import com.gmao.gmao_backend.model.Marcas;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.MarcasRepository;
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
public class MarcasService {
    
    private final MarcasRepository marcasRepository;
    private final AdministracionUsuariosRepository usuarioRepository;
    private final MarcasMapper marcasMapper;

    public MarcasService(MarcasRepository MarcasRepository, AdministracionUsuariosRepository usuarioRepository, MarcasMapper marcasMapper) {
        this.marcasRepository = MarcasRepository;
        this.usuarioRepository = usuarioRepository;
        this.marcasMapper = marcasMapper;
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
    public Page<MarcasDTO> findAll(int page, int size, String sortField, String sortDirection, MarcasDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Marcas> ordenPage = marcasRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            validateNullFilters(predicates, criteriaBuilder, root.get("estado"), filterDTO.getEstado());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        // Convertir la página de entidades a una página de DTOs
        return ordenPage.map(marcasMapper::toDto);
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<MarcasDTO> findById(Long id) {
        return marcasRepository.findById(id)
                                     .map(marcasMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public MarcasDTO save(MarcasDTO marcasDTO) {
        AdministracionUsuarios solicitante = usuarioRepository.findById(marcasDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
    
        // Convierte el DTO a entidad y establece el solicitante manualmente
        Marcas marcas = marcasMapper.toEntity(marcasDTO);
        marcas.setIngresado_por(solicitante);
    
        Marcas savedMarcas = marcasRepository.save(marcas);
        return marcasMapper.toDto(savedMarcas);
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public MarcasDTO update(Long id, MarcasDTO marcasDTO) {
        Marcas existingMarcas = marcasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrada"));

        // Actualizar el solicitante si está presente en el DTO
        if (marcasDTO.getIngresado_porId() != null) {
            AdministracionUsuarios solicitante = usuarioRepository.findById(marcasDTO.getIngresado_porId())
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado"));
            existingMarcas.setIngresado_por(solicitante);
        }

        // Utiliza MapStruct para actualizar solo los valores no nulos
        marcasMapper.updateFromDto(marcasDTO, existingMarcas);

        // Guarda la entidad actualizada
        Marcas updatedOrdenTrabajo = marcasRepository.save(existingMarcas);
        return marcasMapper.toDto(updatedOrdenTrabajo);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        marcasRepository.deleteById(id);
    }
}