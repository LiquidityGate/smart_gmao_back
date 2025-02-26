package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "actividades_gestion")
public class ActividadGestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(name = "estado", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean estado = true;

    @Column(name = "estado_eliminado", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean estadoEliminado = false;

    @CreationTimestamp
    @Column(name = "creado_en", updatable = false)
    private Timestamp creadoEn;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "actualizado_en")
    private Timestamp actualizadoEn;

    @Column(name = "actualizado_por")
    private Long actualizadoPor;

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

    public Long getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Timestamp getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(Timestamp actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public Long getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(Long actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public Boolean getEstadoEliminado() {
        return estadoEliminado;
    }

    public void setEstadoEliminado(Boolean estadoEliminado) {
        this.estadoEliminado = estadoEliminado;
    }

}