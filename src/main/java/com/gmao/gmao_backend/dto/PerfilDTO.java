package com.gmao.gmao_backend.dto;

public class PerfilDTO {

    private Long id;
    private String perfil;

    // Constructor vacío
    public PerfilDTO() {
    }

    public PerfilDTO(Long id, String perfil) {
        this.id = id;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}