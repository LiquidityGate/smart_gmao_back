package com.gmao.gmao_backend.controller;

import com.gmao.gmao_backend.dto.Auth.AuthAccesoMenuDTO;
import com.gmao.gmao_backend.dto.Auth.AuthPermisosMenuDTO;
import com.gmao.gmao_backend.dto.Auth.AuthSesionesDTO;
import com.gmao.gmao_backend.model.AuthenticationRequest;
import com.gmao.gmao_backend.model.AuthenticationResponse;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.repository.UsuarioRepository;
import com.gmao.gmao_backend.security.CustomUserDetails;
import com.gmao.gmao_backend.security.JwtUtil;
import com.gmao.gmao_backend.service.AdministracionUsuariosService;
import com.gmao.gmao_backend.service.AuthService;
import com.gmao.gmao_backend.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AdministracionUsuariosService userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
            HttpServletRequest request)
            throws Exception {

        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        String userAgent = request.getHeader("User-Agent");
        AuthSesionesDTO dto = new AuthSesionesDTO();

        dto.setIpAddress(ipAddress);
        dto.setUserAgent(userAgent);

        try {
            // Autenticar usuario
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            dto.setAcceso(false);
            throw new Exception("Usuario o contraseña incorrectos", e);
        }

        // Cargar el usuario desde la base de datos
        Usuario usuario = userDetailsService.findByUsername(authenticationRequest.getUsername())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        // Generar el token JWT con username y userId
        final String jwt = jwtUtil.generateToken(usuario.getUsuario(), usuario.getId());

        usuario.setTokenJWT(jwt);
        usuarioRepository.save(usuario);

        dto.setAcceso(true);
        dto.setTokenJWT(jwt);
        Long sessionId = authService.insertLogSesiones(usuario, dto);

        // Devolver el token JWT en la respuesta
        return new AuthenticationResponse(jwt, sessionId, usuario.getId());
    }

    @PostMapping("/accesoMenu")
    public ResponseEntity<Boolean> getAccesoMenu(HttpServletRequest request,
            Principal principal,
            @RequestBody AuthAccesoMenuDTO dto)
            throws Exception {

        // Obtener el usuario
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Usuario usuarioP = usuarioService.getUsuarioPorId(customUserDetails.getId());

        // Verificar el acceso al menú
        Boolean respuestaAccesoMenu = authService.getAccesoMenu(dto.getRuta(), usuarioP);

        // Obtener la IP y User-Agent de la solicitud
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        String userAgent = request.getHeader("User-Agent");

        // Obtener el token JWT de la cabecera Authorization
        String tokenJWT = request.getHeader("Authorization");
        if (tokenJWT != null && tokenJWT.startsWith("Bearer ")) {
            tokenJWT = tokenJWT.substring(7); // Eliminar "Bearer " del inicio
        }

        // Asignar valores al DTO
        dto.setIpAddress(ipAddress);
        dto.setUserAgent(userAgent);
        dto.setAccesoMenu(respuestaAccesoMenu);
        dto.setTokenJWT(tokenJWT);

        // Registrar el log
        authService.insertLogModulos(usuarioP, dto);

        // Retornar la respuesta
        return ResponseEntity.ok(respuestaAccesoMenu);
    }

    @PostMapping("/permisosMenu")
    public ResponseEntity<List<AuthPermisosMenuDTO>> getMenu(Principal principal, @RequestBody AuthAccesoMenuDTO dto)
            throws Exception {

        Usuario usuarioP = usuarioService.getUsuario(principal.getName());
        return ResponseEntity.ok(
                authService.getPermisosMenu(dto.getRuta(), usuarioP.getPerfil().getId()));
    }
}