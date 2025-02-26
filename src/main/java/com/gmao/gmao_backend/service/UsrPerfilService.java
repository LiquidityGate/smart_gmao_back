package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.ListaTiposIdentidadDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.mapper.UsuarioPerfilMapper;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.repository.UsuarioPerfilRepository;
import com.gmao.gmao_backend.repository.UsuarioRepository;
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
import java.util.stream.Collectors;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsrPerfilService {

    private final UsuarioPerfilRepository usrPerfilRepository;
    private final UsuarioPerfilMapper usrPerfilMapper;
    private final UsuarioRepository usuarioRepository;

    public UsrPerfilService(UsuarioPerfilRepository usrPerfilRepository, UsuarioPerfilMapper usrPerfilMapper,
            UsuarioRepository usuarioRepository) {
        this.usrPerfilRepository = usrPerfilRepository;
        this.usrPerfilMapper = usrPerfilMapper;
        this.usuarioRepository = usuarioRepository;
    }

    // Método para validar filtros de tipo String
    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field,
            String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(field), "%" + value.toLowerCase() + "%"));
        }
    }

    // Método para validar filtros de tipo Long (para IDs)
    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field,
            Long value) {
        if (value != null) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las órdenes de trabajo con filtros y paginación
    public Page<MantenimientoPerfilesDTO> findAll(int page, int size, String sortField, String sortDirection,
            MantenimientoPerfilesDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        return usrPerfilRepository.findAllDTO(pageable, filterDTO.getNombre());
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<MantenimientoPerfilesDTO> findById(Long id) {
        return usrPerfilRepository.findById(id).map(usrPerfilMapper::toDto);
    }

    // Crear una nueva orden de trabajo
    public MantenimientoPerfilesDTO save(MantenimientoPerfilesDTO usrPerfilDTO) {
        // Convierte el DTO a entidad
        UsuarioPerfil usrPerfil = usrPerfilMapper.toEntity(usrPerfilDTO);

        UsuarioPerfil savedUsrPerfil = usrPerfilRepository.save(usrPerfil);
        return usrPerfilRepository.findDTOById(savedUsrPerfil.getId());
    }

    // Actualizar una orden de trabajo existente con actualización parcial
    public Map<String, Object> update(Long id, MantenimientoPerfilesDTO usrPerfilDTO) {
        MantenimientoPerfilesDTO existingDTO = usrPerfilRepository.findDTOById(id);
        UsuarioPerfil existingUsrPerfil = usrPerfilMapper.toEntity(existingDTO);

        // UsuarioPerfil existingUsrPerfil = usrPerfilRepository.findById(id)
        // .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        // Utiliza MapStruct para actualizar solo los valores no nulos
        usrPerfilMapper.updateFromDto(usrPerfilDTO, existingUsrPerfil);

        // Guarda la entidad actualizada
        UsuarioPerfil updatedUsrPerfil = usrPerfilRepository.save(existingUsrPerfil);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", usrPerfilRepository.findDTOById(updatedUsrPerfil.getId()));
        result.put("existingDTO", existingDTO);

        return result;
    }

    // Eliminar una orden de trabajo por ID
    public void deleteById(Long id) {
        usrPerfilRepository.deleteById(id);
    }

    // Método para obtener solo los campos necesarios para el select box
    public List<MantenimientoPerfilesDTO> findAllForSelect() {
        return usrPerfilRepository.findAll().stream().map(usuarioPerfil -> {
            String creadoPorNombre = getUsuarioNombre(usuarioPerfil.getCreadoPor());
            String actualizadoPorNombre = getUsuarioNombre(usuarioPerfil.getActualizadoPor());
            return usrPerfilMapper.toDto(usuarioPerfil, creadoPorNombre, actualizadoPorNombre);
        }).collect(Collectors.toList());
    }

    private String getUsuarioNombre(Long usuarioId) {
        if (usuarioId == null) {
            return null;
        }
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        return usuarioOpt.map(usuario -> usuario.getNombres() + " " + usuario.getApellidos()).orElse(null);
    }

}