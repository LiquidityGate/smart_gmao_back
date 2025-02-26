package com.gmao.gmao_backend.dto.Configuracion;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConfiguracionTurnoDTO {

    private Long id;
    private String nombre;
    private String horaEntrada;
    private String horaSalida;
    private Boolean diasDescanso1;
    private Boolean diasDescanso2;
    private Boolean diasDescanso3;
    private Boolean diasDescanso4;
    private Boolean diasDescanso5;
    private Boolean diasDescanso6;
    private Boolean diasDescanso7;
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

    public ConfiguracionTurnoDTO() {
    }

    public ConfiguracionTurnoDTO(Long id, String nombre, String horaEntrada, String horaSalida, Boolean diasDescanso1,
            Boolean diasDescanso2, Boolean diasDescanso3, Boolean diasDescanso4, Boolean diasDescanso5,
            Boolean diasDescanso6, Boolean diasDescanso7, Boolean estado, Boolean estadoEliminado, Timestamp creadoEn,
            Long creadoPorId, String creadoPorNombre, Timestamp actualizadoEn, Long actualizadoPorId,
            String actualizadoPorNombre) {
        this.id = id;
        this.nombre = nombre;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.diasDescanso1 = diasDescanso1;
        this.diasDescanso2 = diasDescanso2;
        this.diasDescanso3 = diasDescanso3;
        this.diasDescanso4 = diasDescanso4;
        this.diasDescanso5 = diasDescanso5;
        this.diasDescanso6 = diasDescanso6;
        this.diasDescanso7 = diasDescanso7;
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