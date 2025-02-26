package com.gmao.gmao_backend.dto;

public class Alm_condicion_pagoDTO {

    private Long id;
    private String nombre;
    private String estado;

    public Alm_condicion_pagoDTO() {}

    public Alm_condicion_pagoDTO(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}