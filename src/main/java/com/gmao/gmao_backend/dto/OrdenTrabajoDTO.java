package com.gmao.gmao_backend.dto;

import java.sql.Date;

public class OrdenTrabajoDTO {

    private Long id;
    private String numero;
    private String descripcion;
    private String estado;
    private Date fechaApertura;
    private Long solicitanteId;          // ID del solicitante
    private String solicitanteNombre;     // Nombre del solicitante
    private String tipo;
    private String sitio;
    private String prioridad;
    private Date fechaInicioPrevisto;
    private Date fechaFinalAsignacion;
    private Date fechaFinalCierre;
    private String nota;

    // Constructor vacío
    public OrdenTrabajoDTO() {}

    // Constructor con todos los campos
    public OrdenTrabajoDTO(Long id, String numero, String descripcion, String estado, String tipo, String prioridad, String sitio, Date fechaApertura, Date fechaFinalAsignacion, Date fechaInicioPrevisto, Date fechaFinalCierre, String nota, Long solicitanteId, String solicitanteNombre) {
        this.id = id;
        this.numero = numero;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.solicitanteId = solicitanteId;
        this.solicitanteNombre = solicitanteNombre;
        this.tipo = tipo;
        this.sitio = sitio;
        this.prioridad = prioridad;
        this.fechaInicioPrevisto = fechaInicioPrevisto;
        this.fechaFinalAsignacion = fechaFinalAsignacion;
        this.fechaFinalCierre = fechaFinalCierre;
        this.nota = nota;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public String getSolicitanteNombre() {
        return solicitanteNombre;
    }

    public void setSolicitanteNombre(String solicitanteNombre) {
        this.solicitanteNombre = solicitanteNombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechaInicioPrevisto() {
        return fechaInicioPrevisto;
    }

    public void setFechaInicioPrevisto(Date fechaInicioPrevisto) {
        this.fechaInicioPrevisto = fechaInicioPrevisto;
    }

    public Date getFechaFinalAsignacion() {
        return fechaFinalAsignacion;
    }

    public void setFechaFinalAsignacion(Date fechaFinalAsignacion) {
        this.fechaFinalAsignacion = fechaFinalAsignacion;
    }

    public Date getFechaFinalCierre() {
        return fechaFinalCierre;
    }

    public void setFechaFinalCierre(Date fechaFinalCierre) {
        this.fechaFinalCierre = fechaFinalCierre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "OrdenTrabajoDTO{" +
                "numero='" + numero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", tipo='" + tipo + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", sitio='" + sitio + '\'' +
                ", solicitanteId=" + solicitanteId +
                '}';
    }
}