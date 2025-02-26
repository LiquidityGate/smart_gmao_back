package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.UserProfileDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectamos el PasswordEncoder

    public Usuario registrarUsuario(Usuario usuario) {
        // Encriptar la contraseña antes de guardarla
        String passwordEncriptado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);

        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    public UserProfileDTO getUserProfile(String username) {
        // Lógica para obtener el perfil del usuario desde la base de datos
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(username);

        Usuario usuario = usuarioOptional.get();
        return new UserProfileDTO(usuario.getNombres(), usuario.getApellidos(), usuario.getCorreo());

    }

    public Usuario getUsuario(String username) {
        // Lógica para obtener el perfil del usuario desde la base de datos
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(username);

        Usuario usuario = usuarioOptional.get();
        return usuario;

    }

    public Usuario getUsuarioPorId(Long id) {
        // Lógica para obtener el perfil del usuario desde la base de datos
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        Usuario usuario = usuarioOptional.get();
        return usuario;
    }
}