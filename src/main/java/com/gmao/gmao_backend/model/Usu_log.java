package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

import org.hibernate.annotations.Immutable;

@Immutable
@Entity
@Table(name = "vg_usu_log2")
public class Usu_log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String nombres;
    private String apellidos;
    private String fecha_ult_conexion;
    private Long nro;

    public Usu_log() {}

    public Usu_log(Long id, String usuario, String nombres, String apellidos, String fecha_ult_conexion, Long nro) {
        this.id = id;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_ult_conexion = fecha_ult_conexion;
        this.nro = nro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_ult_conexion() {
        return fecha_ult_conexion;
    }

    public void setFecha_ult_conexion(String fecha_ult_conexion) {
        this.fecha_ult_conexion = fecha_ult_conexion;
    }

    public Long getNro() {
        return nro;
    }

    public void setNro(Long nro) {
        this.nro = nro;
    }
}