package com.gmao.gmao_backend.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.service.FileService;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/api/descargar")
public class FileDescargarController {

    private final FileService fileService;

    public FileDescargarController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<Resource> descargarArchivo(@RequestParam("ruta") String ruta) throws IOException {
        ResponseEntity<Resource> response;
        response = fileService.descargarArchivo(ruta);
        return response;
    }
}