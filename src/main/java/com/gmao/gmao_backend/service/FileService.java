package com.gmao.gmao_backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {
    private final String carpetaDescargas = System.getProperty("user.dir") + "/uploads/";

    public ResponseEntity<Map<String, Object>> subirArchivo(MultipartFile archivo, String directorio)
            throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();

        if (archivo.isEmpty()) {
            // Si el archivo está vacío, devolver un mensaje de error
            response.put("message", "Por favor, seleccione un archivo.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            // Usar el directorio proporcionado
            File uploadDir = new File(this.carpetaDescargas + directorio);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Crear el directorio si no existe
            }

            // Guardar el archivo en el directorio especificado
            File destinationFile = new File(uploadDir, archivo.getOriginalFilename());
            archivo.transferTo(destinationFile);

            // Devolver un mensaje de éxito con el nombre del archivo
            response.put("message", "Archivo subido correctamente: " + destinationFile.getName());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            // Si ocurre un error, devolver un mensaje de error
            response.put("message", "Error al subir el archivo: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String subirArchivoGeneral(MultipartFile archivo, String directorio)
            throws JsonProcessingException {

        if (archivo == null) {
            return "No hay archivo a subir";
        }

        // Luego verificamos si el archivo está vacío
        if (archivo.isEmpty()) {
            return "El archivo está vacío";
        }

        try {
            File uploadDir = new File(this.carpetaDescargas + directorio);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Guardar el archivo en el directorio especificado
            File destinationFile = new File(uploadDir, archivo.getOriginalFilename());
            archivo.transferTo(destinationFile);

            return "Archivo subido correctamente: " + destinationFile.getName();
        } catch (IOException e) {
            return "Error al subir el archivo";
        }
    }

    public ResponseEntity<Resource> descargarArchivo(String archivo)
            throws JsonProcessingException, IOException {

        // Obtén la ruta completa del archivo
        Path filePath = Paths.get(this.carpetaDescargas + archivo);
        Resource resource = new FileSystemResource(filePath);

        // Si el archivo no existe, responde con 404
        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Determina el tipo de archivo (MIME type) basado en la extensión del archivo
        String contentType = Files.probeContentType(filePath);
        if (contentType == null) {
            // Si no se puede determinar, se puede asumir un tipo por defecto
            contentType = "application/octet-stream";
        }

        // Devuelve la respuesta con el tipo MIME adecuado
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType)) // Tipo de archivo dinámico
                .body(resource);

    }

}