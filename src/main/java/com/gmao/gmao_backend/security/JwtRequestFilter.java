package com.gmao.gmao_backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gmao.gmao_backend.service.AdministracionUsuariosService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AdministracionUsuariosService usuarioService; // Usamos el servicio en lugar del repositorio

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain chain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        Long userId = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                userId = jwtUtil.extractUserId(jwtToken); // Extraer userId desde el token
            } catch (SecurityException e) { // Usando SecurityException en lugar de SignatureException
                logger.error("Firma JWT no válida: " + e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Firma del JWT no es válida.");
                return;
            } catch (MalformedJwtException e) {
                logger.error("JWT mal formado: " + e.getMessage());
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "JWT mal formado.");
                return;
            } catch (ExpiredJwtException e) {
                logger.error("JWT ha expirado: " + e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "El JWT ha expirado.");
                return;
            } catch (IllegalArgumentException e) {
                logger.error("No se pudo obtener el JWT: " + e.getMessage());
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se pudo obtener el JWT.");
                return;
            } catch (SignatureException e) {
                logger.error("Firma JWT no válida");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT signature is invalid");
                return;
            }
        } else {
            logger.warn("El JWT no comienza con la palabra Bearer o está ausente.");
        }

        // Validar token si se ha obtenido username y si no hay autenticación previa
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            if (!usuarioService.isUserActive(userId)) {
                logger.warn("Usuario inactivo o no autorizado.");
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Usuario inactivo o no autorizado.");
                return;
            }

            CustomUserDetails customUserDetails = this.usuarioService
                    .loadUserByUsername(jwtUtil.extractUsername(jwtToken));

            // Si el token es válido, configura la autenticación
            if (jwtUtil.validateToken(jwtToken, customUserDetails.getUsername())) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        customUserDetails, null, customUserDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Establece el contexto de seguridad con la autenticación del usuario
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                logger.warn("Token JWT no válido.");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token JWT no es válido.");
                return;
            }
        }

        // Continuar con el siguiente filtro
        chain.doFilter(request, response);
    }
}