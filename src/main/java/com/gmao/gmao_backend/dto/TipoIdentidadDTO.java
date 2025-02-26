package com.gmao.gmao_backend.dto;

public class TipoIdentidadDTO {

    private Long id;
    private String tipoIdentidad;

    // Constructor vacío
    public TipoIdentidadDTO() {
    }

    public TipoIdentidadDTO(Long id, String tipoIdentidad) {
        this.id = id;
        this.tipoIdentidad = tipoIdentidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(String tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

}