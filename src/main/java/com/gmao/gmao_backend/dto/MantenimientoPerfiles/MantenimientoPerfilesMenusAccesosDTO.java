package com.gmao.gmao_backend.dto.MantenimientoPerfiles;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MantenimientoPerfilesMenusAccesosDTO {

    private Long id;
    private Long idPerfil;
    private Long idMenu;
    private Boolean estado;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp creadoEn;
    private Long creadoPorId;
    private String creadoPorNombre;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp actualizadoEn;
    private Long actualizadoPorId;
    private String actualizadoPorNombre;
    private String nombrePerfil;
    private String nombreMenu;
    private Boolean crear;
    private Boolean ver;
    private Boolean editar;
    private Boolean eliminar;

    // Constructor vacío
    public MantenimientoPerfilesMenusAccesosDTO() {
    }

    public MantenimientoPerfilesMenusAccesosDTO(Long id, Long idPerfil, Long idMenu, Boolean estado, Timestamp creadoEn,
            Long creadoPorId, String creadoPorNombre, Timestamp actualizadoEn, Long actualizadoPorId,
            String actualizadoPorNombre, String nombrePerfil, String nombreMenu, Boolean crear, Boolean ver,
            Boolean editar, Boolean eliminar) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.idMenu = idMenu;
        this.estado = estado;
        this.creadoEn = creadoEn;
        this.creadoPorId = creadoPorId;
        this.creadoPorNombre = creadoPorNombre;
        this.actualizadoEn = actualizadoEn;
        this.actualizadoPorId = actualizadoPorId;
        this.actualizadoPorNombre = actualizadoPorNombre;
        this.nombrePerfil = nombrePerfil;
        this.nombreMenu = nombreMenu;
        this.crear = crear;
        this.ver = ver;
        this.editar = editar;
        this.eliminar = eliminar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
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

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public Boolean getCrear() {
        return crear;
    }

    public void setCrear(Boolean crear) {
        this.crear = crear;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }

}