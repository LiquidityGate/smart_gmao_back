package com.gmao.gmao_backend.dto.Auth;

public class AuthPermisosMenuDTO {

    private String ruta;
    private Long id_perfil;
    private Boolean estado;
    private Boolean crear;
    private Boolean ver;
    private Boolean editar;
    private Boolean eliminar;

    // Constructor vacío
    public AuthPermisosMenuDTO() {
    }

    public AuthPermisosMenuDTO(String ruta, Long id_perfil, Boolean estado, Boolean crear, Boolean ver,
            Boolean editar, Boolean eliminar) {
        this.ruta = ruta;
        this.id_perfil = id_perfil;
        this.estado = estado;
        this.crear = crear;
        this.ver = ver;
        this.editar = editar;
        this.eliminar = eliminar;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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