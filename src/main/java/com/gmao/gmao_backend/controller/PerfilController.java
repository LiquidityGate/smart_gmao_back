package com.gmao.gmao_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmao.gmao_backend.dto.PerfilDTO;
import com.gmao.gmao_backend.mapper.PerfilMapper;
import com.gmao.gmao_backend.model.Perfil;
import com.gmao.gmao_backend.repository.PerfilRepository;
import com.gmao.gmao_backend.service.PerfilService;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir este origen
public class PerfilController {

    private final PerfilService perfilService;
    private final PerfilMapper perfilMapper;

    public PerfilController(PerfilService perfilService,
            PerfilMapper perfilMapper) {
        this.perfilService = perfilService;
        this.perfilMapper = perfilMapper;
    }

    @GetMapping("/api/lista_perfil")
    public ResponseEntity<Page<PerfilDTO>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection,
            PerfilDTO filtros) {

        // Llama al servicio para obtener el resultado paginado de OrdenTrabajo
        Page<Perfil> result = perfilService.findAll(page, size, sortField,
                sortDirection, filtros);

        // Convierte cada OrdenTrabajo a OrdenTrabajoDTO utilizando el mapper
        Page<PerfilDTO> dtoPage = result.map(orden -> perfilMapper.toDto(orden));

        return ResponseEntity.ok(dtoPage);
    }

}
