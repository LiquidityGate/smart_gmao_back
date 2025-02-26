package com.gmao.gmao_backend.dto;

public class ListaSubtipoDTO {

    private Long id;
    private String subtipo;

    // Constructor vacío
    public ListaSubtipoDTO() {
    }

    public ListaSubtipoDTO(Long id, String subtipo) {
        this.id = id;
        this.subtipo = subtipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

}