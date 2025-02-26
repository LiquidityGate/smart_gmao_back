package com.gmao.gmao_backend.dto;

import java.sql.Timestamp;

public class MantenimientoPerfilesDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Timestamp creadoEn;
    private Long creadoPorId;
    private String creadoPorNombre;
    private Timestamp actualizadoEn;
    private Long actualizadoPorId;
    private String actualizadoPorNombre;

    // Constructor vacío
    public MantenimientoPerfilesDTO() {
    }

    public MantenimientoPerfilesDTO(Long id, String nombre, String descripcion, Boolean estado, Timestamp creadoEn,
            Long creadoPorId, String creadoPorNombre, Timestamp actualizadoEn, Long actualizadoPorId,
            String actualizadoPorNombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.creadoEn = creadoEn;
        this.creadoPorId = creadoPorId;
        this.creadoPorNombre = creadoPorNombre;
        this.actualizadoEn = actualizadoEn;
        this.actualizadoPorId = actualizadoPorId;
        this.actualizadoPorNombre = actualizadoPorNombre;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Timestamp getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Timestamp creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Long getCreadoPorId() {
        return creadoPorId;
    }

    public void setCreadoPorId(Long creadoPorId) {
        this.creadoPorId = creadoPorId;
    }

    public String getCreadoPorNombre() {
        return creadoPorNombre;
    }

    public void setCreadoPorNombre(String creadoPorNombre) {
        this.creadoPorNombre = creadoPorNombre;
    }

    public Timestamp getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(Timestamp actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public Long getActualizadoPorId() {
        return actualizadoPorId;
    }

    public void setActualizadoPorId(Long actualizadoPorId) {
        this.actualizadoPorId = actualizadoPorId;
    }

    public String getActualizadoPorNombre() {
        return actualizadoPorNombre;
    }

    public void setActualizadoPorNombre(String actualizadoPorNombre) {
        this.actualizadoPorNombre = actualizadoPorNombre;
    }

}