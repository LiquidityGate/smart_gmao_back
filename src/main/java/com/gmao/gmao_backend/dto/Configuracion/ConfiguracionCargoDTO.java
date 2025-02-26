package com.gmao.gmao_backend.dto.Configuracion;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConfiguracionCargoDTO {

    private Long id;
    private String nombre;
    private Boolean estado;
    private Boolean estadoEliminado;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp creadoEn;
    private Long creadoPorId;
    private String creadoPorNombre;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp actualizadoEn;
    private Long actualizadoPorId;
    private String actualizadoPorNombre;

    // Constructor vacío
    public ConfiguracionCargoDTO() {
    }

    public ConfiguracionCargoDTO(Long id, String nombre, Boolean estado, Boolean estadoEliminado, Timestamp creadoEn,
            Long creadoPorId, String creadoPorNombre, Timestamp actualizadoEn, Long actualizadoPorId,
            String actualizadoPorNombre) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.estadoEliminado = estadoEliminado;
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

    public Boolean getEstadoEliminado() {
        return estadoEliminado;
    }

    public void setEstadoEliminado(Boolean estadoEliminado) {
        this.estadoEliminado = estadoEliminado;
    }

}