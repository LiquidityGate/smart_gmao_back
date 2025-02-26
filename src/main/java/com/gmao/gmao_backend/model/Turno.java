package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(name = "hora_entrada", length = 20)
    private String horaEntrada;

    @Column(name = "hora_salida", length = 20)
    private String horaSalida;

    @Column(name = "dias_descanso1", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso1 = false;

    @Column(name = "dias_descanso2", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso2 = false;

    @Column(name = "dias_descanso3", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso3 = false;

    @Column(name = "dias_descanso4", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso4 = false;

    @Column(name = "dias_descanso5", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso5 = false;

    @Column(name = "dias_descanso6", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso6 = false;

    @Column(name = "dias_descanso7", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean diasDescanso7 = false;

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

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Boolean getDiasDescanso1() {
        return diasDescanso1;
    }

    public void setDiasDescanso1(Boolean diasDescanso1) {
        this.diasDescanso1 = diasDescanso1;
    }

    public Boolean getDiasDescanso2() {
        return diasDescanso2;
    }

    public void setDiasDescanso2(Boolean diasDescanso2) {
        this.diasDescanso2 = diasDescanso2;
    }

    public Boolean getDiasDescanso3() {
        return diasDescanso3;
    }

    public void setDiasDescanso3(Boolean diasDescanso3) {
        this.diasDescanso3 = diasDescanso3;
    }

    public Boolean getDiasDescanso4() {
        return diasDescanso4;
    }

    public void setDiasDescanso4(Boolean diasDescanso4) {
        this.diasDescanso4 = diasDescanso4;
    }

    public Boolean getDiasDescanso5() {
        return diasDescanso5;
    }

    public void setDiasDescanso5(Boolean diasDescanso5) {
        this.diasDescanso5 = diasDescanso5;
    }

    public Boolean getDiasDescanso6() {
        return diasDescanso6;
    }

    public void setDiasDescanso6(Boolean diasDescanso6) {
        this.diasDescanso6 = diasDescanso6;
    }

    public Boolean getDiasDescanso7() {
        return diasDescanso7;
    }

    public void setDiasDescanso7(Boolean diasDescanso7) {
        this.diasDescanso7 = diasDescanso7;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoEliminado() {
        return estadoEliminado;
    }

    public void setEstadoEliminado(Boolean estadoEliminado) {
        this.estadoEliminado = estadoEliminado;
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

}