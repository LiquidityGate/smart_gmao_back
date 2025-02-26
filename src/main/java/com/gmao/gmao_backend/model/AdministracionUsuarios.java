package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_usuarios")
public class AdministracionUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 255)
    private String usuario;

    @Column(length = 100)
    private String contraseña;

    @Column(length = 255)
    private String remember_token;

    @Column(length = 100)
    private String nombres;

    @Column(length = 100)
    private String apellidos;

    @Column(name = "num_identidad", length = 20)
    private String numIdentidad;

    @ManyToOne
    @JoinColumn(name = "id_identidad")
    private UsuarioTiposIdentidad tipoIdentidad; // Asegúrate de crear la entidad TipoIdentidad

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_subtipo")
    private UsuarioSubtipo subtipoUsuario; // Asegúrate de crear la entidad SubtipoUsuario

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private UsuarioPerfil perfil; // Asegúrate de crear la entidad Perfil

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa; // Asegúrate de crear la entidad Empresa

    @Column(name = "id_usuario_registro")
    private Long idUsuarioRegistro;

    @Column(name = "fecha_registro", updatable = false)
    private Timestamp fechaRegistro;

    @Column(name = "id_usuario_actualizacion")
    private Long idUsuarioActualizacion;

    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;

    @Column(name = "fecha_ult_conexion")
    private Timestamp fechaUltConexion;

    // Getters y Setters
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRememberToken() {
        return remember_token;
    }

    public void setRememberToken(String remember_token) {
        this.remember_token = remember_token;
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

    public String getNumIdentidad() {
        return numIdentidad;
    }

    public void setNumIdentidad(String numIdentidad) {
        this.numIdentidad = numIdentidad;
    }

    public UsuarioTiposIdentidad getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(UsuarioTiposIdentidad tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public UsuarioSubtipo getSubtipoUsuario() {
        return subtipoUsuario;
    }

    public void setSubtipoUsuario(UsuarioSubtipo subtipoUsuario) {
        this.subtipoUsuario = subtipoUsuario;
    }

    public UsuarioPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(UsuarioPerfil perfil) {
        this.perfil = perfil;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Long getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Long idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdUsuarioActualizacion() {
        return idUsuarioActualizacion;
    }

    public void setIdUsuarioActualizacion(Long idUsuarioActualizacion) {
        this.idUsuarioActualizacion = idUsuarioActualizacion;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Timestamp getFechaUltConexion() {
        return fechaUltConexion;
    }

    public void setFechaUltConexion(Timestamp fechaUltConexion) {
        this.fechaUltConexion = fechaUltConexion;
    }
}