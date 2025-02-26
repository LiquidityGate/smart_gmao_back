package com.gmao.gmao_backend.security;

import com.gmao.gmao_backend.service.AdministracionUsuariosService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import java.util.Arrays;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AdministracionUsuariosService myUserDetailsService;

    public SecurityConfig(AdministracionUsuariosService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    // Configurar AuthenticationManagerBuilder para usar MyUserDetailsService y
    // PasswordEncoder
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtRequestFilter jwtRequestFilter)
            throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para APIs stateless
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Usar la configuración de CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login", "/error").permitAll() // Permitir el acceso a las rutas públicas
                        .requestMatchers(HttpMethod.GET, "/api/incidencias/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/actividad/**").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Permitir solicitudes preflight
                                                                                // (OPTIONS)
                        .anyRequest().authenticated() // Exigir autenticación para las demás rutas
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No mantener sesiones (API stateless)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Habilitar CORS globalmente
    // Definir la configuración de CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost",
                "http://192.168.0.105", "http://192.168.1.185", "http://181.65.147.106")); // Origen permitido (URL del
                                                                                           // frontend)
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Headers permitidos
        configuration.setAllowCredentials(true); // Permitir credenciales (si es necesario)
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplicar configuración a todos los endpoints
        return source;
    }
}