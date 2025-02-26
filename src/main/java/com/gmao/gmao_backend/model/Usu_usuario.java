package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usu_usuarios")
public class Usu_usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String nombre;
    private String email;
    private String telefono;
    private String tipo_documento;
    private String nro_documento;
    private String cargo;
    private String perfil;
    private String subtipo;
    private String empresa;
    private String turno;
    private String trabajando;
    private String estado;

    public Usu_usuario() {}

    public Usu_usuario(Long id, String usuario, String nombre, String email, String telefono, String tipo_documento, String nro_documento, String cargo, String perfil, String subtipo, String empresa, String turno, String trabajando, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tipo_documento = tipo_documento;
        this.nro_documento = nro_documento;
        this.cargo = cargo;
        this.perfil = perfil;
        this.subtipo = subtipo;
        this.empresa = empresa;
        this.turno = turno;
        this.trabajando = trabajando;
        this.estado = estado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTrabajando() {
        return trabajando;
    }

    public void setTrabajando(String trabajando) {
        this.trabajando = trabajando;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}