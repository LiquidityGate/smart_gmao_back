package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "ordenes_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    private String descripcion;

    private String estado;

    @Column(name = "fecha_apertura", nullable = false)
    private Date fechaApertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitante_id")
    private AdministracionUsuariosIDName solicitante;

    private String tipo;

    private String sitio;

    private String prioridad;

    @Column(name = "fecha_inicio_previsto")
    private Date fechaInicioPrevisto;

    @Column(name = "fecha_final_asignacion")
    private Date fechaFinalAsignacion;

    @Column(name = "fecha_final_cierre")
    private Date fechaFinalCierre;

    private String nota;

    // Constructor vacío
    public OrdenTrabajo() {}

    // Constructor con todos los campos
    public OrdenTrabajo(String numero, String descripcion, String estado, Date fechaApertura,
    AdministracionUsuariosIDName solicitante, String tipo, String sitio, String prioridad,
                        Date fechaInicioPrevisto, Date fechaFinalAsignacion,
                        Date fechaFinalCierre, String nota) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.solicitante = solicitante;
        this.tipo = tipo;
        this.sitio = sitio;
        this.prioridad = prioridad;
        this.fechaInicioPrevisto = fechaInicioPrevisto;
        this.fechaFinalAsignacion = fechaFinalAsignacion;
        this.fechaFinalCierre = fechaFinalCierre;
        this.nota = nota;
    }

    // Getters y Setters
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

    public AdministracionUsuariosIDName getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(AdministracionUsuariosIDName solicitante) {
        this.solicitante = solicitante;
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
        return "OrdenTrabajo{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaApertura=" + fechaApertura +
                ", solicitante=" + (solicitante != null ? solicitante.getNombres() : "null") +
                ", tipo='" + tipo + '\'' +
                ", sitio='" + sitio + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", fechaInicioPrevisto=" + fechaInicioPrevisto +
                ", fechaFinalAsignacion=" + fechaFinalAsignacion +
                ", fechaFinalCierre=" + fechaFinalCierre +
                ", nota='" + nota + '\'' +
                '}';
    }
}