package com.gmao.gmao_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmao.gmao_backend.dto.MenuDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.service.MenuService;
import com.gmao.gmao_backend.service.UsuarioService;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir este origen
public class MenuController {

    private final MenuService menuService;
    private final UsuarioService usuarioService;

    public MenuController(MenuService menuService, UsuarioService usuarioService) {
        this.menuService = menuService;
        this.usuarioService = usuarioService;
    }

    // Obtener usuarios para el select box
    @GetMapping("/api/lista_menu/select")
    public ResponseEntity<List<MenuDTO>> getAllMenusAcceso(Principal principal) {
        Usuario usuarioP = usuarioService.getUsuario(principal.getName());
        List<MenuDTO> menuDTO = menuService.findAllMenusAcceso(usuarioP.getId(), usuarioP.getPerfil().getId());
        return ResponseEntity.ok(menuDTO);
    }

}
