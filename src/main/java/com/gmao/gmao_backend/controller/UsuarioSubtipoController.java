package com.gmao.gmao_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmao.gmao_backend.dto.ListaSubtipoDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.mapper.UsuarioSubtipoMapper;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import com.gmao.gmao_backend.repository.UsuarioSubtipoRepository;
import com.gmao.gmao_backend.service.SubtipoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir este origen
public class UsuarioSubtipoController {

    private final SubtipoService subtipoService;
    private final UsuarioSubtipoMapper subtipoMapper;

    public UsuarioSubtipoController(SubtipoService subtipoService,
            UsuarioSubtipoMapper subtipoMapper) {
        this.subtipoService = subtipoService;
        this.subtipoMapper = subtipoMapper;
    }

    // Obtener usuarios para el select box
    @GetMapping("/api/lista_subtipo2/select")
    public ResponseEntity<List<ListaSubtipoDTO>> getUsuariosForSelect() {
        List<ListaSubtipoDTO> usuarios = subtipoService.findAllForSelect();
        return ResponseEntity.ok(usuarios);
    }

}
