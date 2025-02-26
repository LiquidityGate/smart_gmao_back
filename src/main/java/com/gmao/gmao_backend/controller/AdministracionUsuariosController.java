package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.AdministracionUsuariosDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;
import com.gmao.gmao_backend.service.AdministracionUsuariosService;
import com.gmao.gmao_backend.mapper.AdministracionUsuariosMapper;
import com.gmao.gmao_backend.repository.AdministracionUsuariosRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administracion-usuarios")
public class AdministracionUsuariosController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AdministracionUsuariosService administracionUsuariosService;
    private final AdministracionUsuariosMapper administracionUsuariosMapper;
    private final AdministracionUsuariosRepository administracionUsuariosRepository;

    public AdministracionUsuariosController(AdministracionUsuariosService administracionUsuariosService,
            AdministracionUsuariosMapper administracionUsuariosMapper,
            AdministracionUsuariosRepository administracionUsuariosRepository) {
        this.administracionUsuariosService = administracionUsuariosService;
        this.administracionUsuariosMapper = administracionUsuariosMapper;
        this.administracionUsuariosRepository = administracionUsuariosRepository;
    }

    // Obtener todos los usuarios con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<AdministracionUsuariosDTO>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection,
            AdministracionUsuariosDTO filtros) {

        Page<AdministracionUsuarios> result = administracionUsuariosService.findAll(page, size, sortField,
                sortDirection, filtros);

        Page<AdministracionUsuariosDTO> dtoPage = result.map(administracionUsuariosMapper::toDto);

        return ResponseEntity.ok(dtoPage);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<AdministracionUsuariosDTO> getById(@PathVariable Long id) {
        Optional<AdministracionUsuarios> administracionUsuarios = administracionUsuariosService.findById(id);
        return administracionUsuarios
                .map(user -> ResponseEntity.ok(administracionUsuariosMapper.toDto(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<AdministracionUsuariosDTO> create(
            @RequestBody AdministracionUsuariosDTO administracionUsuariosDTO) {
        AdministracionUsuarios administracionUsuarios = administracionUsuariosMapper
                .toEntity(administracionUsuariosDTO);
        Long perfilId = administracionUsuariosDTO.getIdPerfil();
        UsuarioPerfil perfil = new UsuarioPerfil();
        perfil.setId(perfilId);
        administracionUsuarios.setPerfil(perfil);

        Long subtipoId = administracionUsuariosDTO.getIdSubtipoUsuario();
        UsuarioSubtipo subtipo = new UsuarioSubtipo();
        subtipo.setId(subtipoId);
        administracionUsuarios.setSubtipoUsuario(subtipo);

        Long tipoIdentidadId = administracionUsuariosDTO.getIdTipoIdentidad();
        UsuarioTiposIdentidad tipoIdentidad = new UsuarioTiposIdentidad();
        tipoIdentidad.setId(tipoIdentidadId);
        administracionUsuarios.setTipoIdentidad(tipoIdentidad);

        // Encriptar la nueva contraseña
        String contrasena = administracionUsuariosDTO.getContraseña();
        administracionUsuarios.setContraseña(passwordEncoder.encode(contrasena));
        ;

        AdministracionUsuarios savedUser = administracionUsuariosService.save(administracionUsuarios);
        return ResponseEntity.ok(administracionUsuariosMapper.toDto(savedUser));
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<AdministracionUsuariosDTO> update(@PathVariable Long id,
            @RequestBody AdministracionUsuariosDTO administracionUsuariosDTO) {
        Optional<AdministracionUsuarios> existingUser = administracionUsuariosService.findById(id);
        if (existingUser.isPresent()) {
            AdministracionUsuarios administracionUsuarios = administracionUsuariosMapper
                    .toEntity(administracionUsuariosDTO);

            Long perfilId = administracionUsuariosDTO.getIdPerfil();
            UsuarioPerfil perfil = new UsuarioPerfil();
            perfil.setId(perfilId);
            administracionUsuarios.setPerfil(perfil);

            Long subtipoId = administracionUsuariosDTO.getIdSubtipoUsuario();
            UsuarioSubtipo subtipo = new UsuarioSubtipo();
            subtipo.setId(subtipoId);
            administracionUsuarios.setSubtipoUsuario(subtipo);

            Long tipoIdentidadId = administracionUsuariosDTO.getIdTipoIdentidad();
            UsuarioTiposIdentidad tipoIdentidad = new UsuarioTiposIdentidad();
            tipoIdentidad.setId(tipoIdentidadId);
            administracionUsuarios.setTipoIdentidad(tipoIdentidad);

            administracionUsuarios.setId(id);
            AdministracionUsuarios updatedUser = administracionUsuariosService.update(administracionUsuarios);
            return ResponseEntity.ok(administracionUsuariosMapper.toDto(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        administracionUsuariosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener usuarios para el select box
    @GetMapping("/select")
    public ResponseEntity<List<UsuarioSelectDTO>> getUsuariosForSelect() {
        List<UsuarioSelectDTO> usuarios = administracionUsuariosService.findAllForSelect();
        return ResponseEntity.ok(usuarios);
    }
}