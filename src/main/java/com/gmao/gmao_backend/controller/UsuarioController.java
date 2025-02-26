package com.gmao.gmao_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmao.gmao_backend.dto.UserProfileDTO;
import com.gmao.gmao_backend.security.JwtUtil;
import com.gmao.gmao_backend.service.UsuarioService;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    private final UsuarioService userService;

    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            UserProfileDTO userProfile = userService.getUserProfile(userDetails.getUsername());
            return ResponseEntity.ok(userProfile);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}