package com.gmao.gmao_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmao.gmao_backend.dto.ListaTiposIdentidadDTO;
import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.mapper.UsuarioTipoIdentidadMapper;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;
import com.gmao.gmao_backend.repository.UsuarioTipoIdentidadRepository;
import com.gmao.gmao_backend.service.TipoIdentidadService;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir este origen
public class UsuarioTipoIdentidadController {

    private final TipoIdentidadService tipoIdentidadService;
    private final UsuarioTipoIdentidadMapper tipoIdentidadMapper;

    public UsuarioTipoIdentidadController(TipoIdentidadService tipoIdentidadService,
            UsuarioTipoIdentidadMapper tipoIdentidadMapper) {
        this.tipoIdentidadService = tipoIdentidadService;
        this.tipoIdentidadMapper = tipoIdentidadMapper;
    }

    @GetMapping("/api/lista_identidad")
    public ResponseEntity<Page<ListaTiposIdentidadDTO>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection,
            ListaTiposIdentidadDTO filtros) {

        // Llama al servicio para obtener el resultado paginado de OrdenTrabajo
        Page<UsuarioTiposIdentidad> result = tipoIdentidadService.findAll(page, size, sortField,
                sortDirection, filtros);

        // Convierte cada OrdenTrabajo a OrdenTrabajoDTO utilizando el mapper
        Page<ListaTiposIdentidadDTO> dtoPage = result.map(orden -> tipoIdentidadMapper.toDto(orden));

        return ResponseEntity.ok(dtoPage);
    }

    // Obtener usuarios para el select box
    @GetMapping("/api/lista_identidad/select")
    public ResponseEntity<List<ListaTiposIdentidadDTO>> getUsuariosForSelect() {
        List<ListaTiposIdentidadDTO> usuarios = tipoIdentidadService.findAllForSelect();
        return ResponseEntity.ok(usuarios);
    }

}
