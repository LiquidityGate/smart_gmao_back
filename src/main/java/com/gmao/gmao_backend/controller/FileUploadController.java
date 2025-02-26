package com.gmao.gmao_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.service.FileService;
import com.gmao.gmao_backend.service.FrecuenciaService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private final String carpetaDescargas = System.getProperty("user.dir") + "/uploads/";

    private final FileService fileService;

    public FileUploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("archivo") MultipartFile file,
            @RequestParam("directorio") String directorio) throws JsonProcessingException {
        ResponseEntity<Map<String, Object>> response;

        response = fileService.subirArchivo(file, directorio);
        return response;
    }
}
