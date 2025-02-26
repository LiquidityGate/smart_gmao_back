package com.gmao.gmao_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.gmao.gmao_backend.model.Dispositivo;
import com.gmao.gmao_backend.service.DispositivoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/")
    public ResponseEntity<Page<Dispositivo>> getAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size) {
            Page<Dispositivo> result = dispositivoService.findAll(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public Dispositivo obtenerDispositivo(@PathVariable int id) {
        return dispositivoService.obtenerPorId(id);
    }

    @PostMapping
    public Dispositivo guardarDispositivo(@RequestBody Dispositivo dispositivo) {
        return dispositivoService.guardarDispositivo(dispositivo);
    }

    @DeleteMapping("/{id}")
    public void eliminarDispositivo(@PathVariable int id) {
        dispositivoService.eliminarDispositivo(id);
    }
}
