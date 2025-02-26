package com.gmao.gmao_backend.dto;

public class ListaDTO {

    private Long id;
    private String valor;

    // Constructor vacío
    public ListaDTO() {
    }

    public ListaDTO(Long id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}