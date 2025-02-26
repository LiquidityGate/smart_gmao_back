package com.gmao.gmao_backend.dto;

public class AdministracionUsuariosDTO {

    private Long id;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private String email;
    private String telefono;
    private String numIdentidad;
    private Long idTipoIdentidad;
    private Long idPerfil;
    private Long idSubtipoUsuario;
    private String valorTipoIdentidad;
    private String valorPerfil;
    private String valorSubtipoUsuario;

    // Constructor vacío
    public AdministracionUsuariosDTO() {
    }

    public AdministracionUsuariosDTO(Long id, String nombres, String apellidos, String usuario, String contraseña,
            String email, String telefono, String numIdentidad, Long idTipoIdentidad, Long idPerfil,
            Long idSubtipoUsuario, String valorTipoIdentidad, String valorPerfil, String valorSubtipoUsuario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;
        this.telefono = telefono;
        this.numIdentidad = numIdentidad;
        this.idTipoIdentidad = idTipoIdentidad;
        this.idPerfil = idPerfil;
        this.idSubtipoUsuario = idSubtipoUsuario;
        this.valorTipoIdentidad = valorTipoIdentidad;
        this.valorPerfil = valorPerfil;
        this.valorSubtipoUsuario = valorSubtipoUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNumIdentidad() {
        return numIdentidad;
    }

    public void setNumIdentidad(String numIdentidad) {
        this.numIdentidad = numIdentidad;
    }

    public Long getIdTipoIdentidad() {
        return idTipoIdentidad;
    }

    public void setIdTipoIdentidad(Long idTipoIdentidad) {
        this.idTipoIdentidad = idTipoIdentidad;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdSubtipoUsuario() {
        return idSubtipoUsuario;
    }

    public void setIdSubtipoUsuario(Long idSubtipoUsuario) {
        this.idSubtipoUsuario = idSubtipoUsuario;
    }

    public String getValorTipoIdentidad() {
        return valorTipoIdentidad;
    }

    public void setValorTipoIdentidad(String valorTipoIdentidad) {
        this.valorTipoIdentidad = valorTipoIdentidad;
    }

    public String getValorPerfil() {
        return valorPerfil;
    }

    public void setValorPerfil(String valorPerfil) {
        this.valorPerfil = valorPerfil;
    }

    public String getValorSubtipoUsuario() {
        return valorSubtipoUsuario;
    }

    public void setValorSubtipoUsuario(String valorSubtipoUsuario) {
        this.valorSubtipoUsuario = valorSubtipoUsuario;
    }

}