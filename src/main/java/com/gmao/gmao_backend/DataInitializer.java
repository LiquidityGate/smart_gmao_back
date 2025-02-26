package com.gmao.gmao_backend;

import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.repository.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initUsuarioDatabase(UsuarioRepository usuarioRepository) {
        return args -> {
            // Verifica si ya existe un registro en la tabla usuarios_portal
            /*if (usuarioRepository.count() == 0) {
                // Crea el usuario inicial
                Usuario usuario = new Usuario();
                usuario.setNombre("Usuario");
                usuario.setApellido("Prueba");
                usuario.setDni(11111111);
                usuario.setCorreo("prueba@prueba.com");
                usuario.setEmpresa("MINISTERIO DE ECONOMIA Y FINANZAS");
                usuario.setRuc("20131370645");
                usuario.setCargo("Operador");
                usuario.setRol(5);
                usuario.setUsuario("prueba@prueba.com");
                usuario.setPassword(new BCryptPasswordEncoder().encode("Qwerty123#"));  // Encriptar la contraseña
                usuario.setRememberToken("");  // Campo opcional
                usuario.setCreatedAt(LocalDateTime.of(2021, 1, 9, 0, 0));
                usuario.setUpdatedAt(LocalDateTime.of(2021, 1, 9, 0, 0));
                usuario.setImagen(null);  // Puedes cambiar esto si es necesario
                usuario.setRecover((short) 0);
                usuario.setEstado((short) 1);

                // Guarda el usuario en la base de datos
                usuarioRepository.save(usuario);
                System.out.println("Usuario 'prueba@prueba.com' creado.");
            } else {
                System.out.println("Usuarios ya existen en la base de datos.");
            }*/
        };
    }
}