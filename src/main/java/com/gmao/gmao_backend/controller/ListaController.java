package com.gmao.gmao_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmao.gmao_backend.dto.ListaDTO;
import com.gmao.gmao_backend.service.ListaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir este origen
public class ListaController {

    private final ListaService listaService;

    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @GetMapping("/api/lista_subtipo/select")
    public ResponseEntity<List<ListaDTO>> getListaSubtipo() {
        List<ListaDTO> lista = listaService.findAllForSelectSubtipo();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/api/lista_tipo_identidad/select")
    public ResponseEntity<List<ListaDTO>> getListaIdentidad() {
        List<ListaDTO> lista = listaService.findAllForSelectTipoIdentidad();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/api/lista_empresa/select")
    public ResponseEntity<List<ListaDTO>> getListaEmpresa() {
        List<ListaDTO> lista = listaService.findAllForSelectEmpresa();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/api/lista_cargo/select")
    public ResponseEntity<List<ListaDTO>> getListaCargo() {
        List<ListaDTO> lista = listaService.findAllForSelectCargo();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/api/lista_turno/select")
    public ResponseEntity<List<ListaDTO>> getListaTurno() {
        List<ListaDTO> lista = listaService.findAllForSelectTurno();
        return ResponseEntity.ok(lista);
    }

}
