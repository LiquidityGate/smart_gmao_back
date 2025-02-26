package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.AdministracionUsuariosDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.repository.AdministracionUsuariosRepository;
import com.gmao.gmao_backend.repository.UsuarioRepository;
import com.gmao.gmao_backend.security.CustomUserDetails;
import com.gmao.gmao_backend.mapper.AdministracionUsuariosMapper;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

@Service
public class AdministracionUsuariosService implements UserDetailsService {

    private final AdministracionUsuariosRepository administracionUsuariosRepository;
    private final UsuarioRepository usuarioRepository;
    private final AdministracionUsuariosMapper administracionUsuariosMapper;

    public AdministracionUsuariosService(AdministracionUsuariosRepository administracionUsuariosRepository,
            AdministracionUsuariosMapper administracionUsuariosMapper, UsuarioRepository usuarioRepository) {
        this.administracionUsuariosRepository = administracionUsuariosRepository;
        this.administracionUsuariosMapper = administracionUsuariosMapper;
        this.usuarioRepository = usuarioRepository;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field,
            String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    private void validateIdGenerico(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field,
            Long value) {
        if (value != null) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    // Obtener todas las órdenes de trabajo con paginación y filtros
    public Page<AdministracionUsuarios> findAll(int page, int size, String sortField, String sortDirection,
            AdministracionUsuariosDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        return administracionUsuariosRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtros dinámicos basados en el DTO
            validateNullFilters(predicates, criteriaBuilder, root.get("nombres"), filterDTO.getNombres());
            validateIdGenerico(predicates, criteriaBuilder,
                    root.get("tipoIdentidad").get("id"),
                    filterDTO.getIdTipoIdentidad());

            validateIdGenerico(predicates, criteriaBuilder,
                    root.get("perfil").get("id"),
                    filterDTO.getIdPerfil());

            // Si no hay filtros, devolver todos los resultados
            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction(); // Esto equivale a no aplicar ningún filtro
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    // Obtener un usuario por ID
    public Optional<AdministracionUsuarios> findById(Long id) {
        return administracionUsuariosRepository.findById(id);
    }

    // Crear un nuevo usuario
    public AdministracionUsuarios save(AdministracionUsuarios administracionUsuarios) {
        return administracionUsuariosRepository.save(administracionUsuarios);
    }

    // Actualizar un usuario existente
    public AdministracionUsuarios update(AdministracionUsuarios administracionUsuarios) {
        return administracionUsuariosRepository.save(administracionUsuarios);
    }

    // Eliminar un usuario por ID
    public void deleteById(Long id) {
        administracionUsuariosRepository.deleteById(id);
    }

    // Método para obtener solo los campos necesarios para el select box
    public List<UsuarioSelectDTO> findAllForSelect() {
        return administracionUsuariosRepository.findAll().stream()
                .map(administracionUsuariosMapper::toUsuarioSelectDto)
                .collect(Collectors.toList());
    }

    public boolean isUserActive(Long id) {
        // Verificamos si el usuario existe y está activo
        return findById(id).map(AdministracionUsuarios::isEstado).orElse(false);
    }

    // Método de UserDetailsService para cargar usuario por nombre de usuario
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdministracionUsuarios usuario = administracionUsuariosRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new CustomUserDetails(usuario.getId(), usuario.getUsuario(), usuario.getContraseña(), new ArrayList<>());
    }

    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsuario(username);
    }
}