package com.gmao.gmao_backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CategoriasDTO implements Serializable {

    private Long id;
    private String nombre;
    private Long idPadre;
    private String nombrePadre;
    private String imagen;
    private byte[] imagenBytes;
    private LocalDateTime fechaRegistro;
    private String estado;

    // Constructor vacío
    public CategoriasDTO() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CategoriasDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idPadre=" + idPadre + '\'' +
                ", nombrePadre='" + nombrePadre + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

}