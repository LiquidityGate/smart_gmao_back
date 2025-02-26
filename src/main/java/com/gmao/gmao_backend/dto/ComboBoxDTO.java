package com.gmao.gmao_backend.dto;

public class ComboBoxDTO {

    private Long id;
    private String valor;

    // Constructor vacío
    public ComboBoxDTO() {
    }

    public ComboBoxDTO(Long id, String valor) {
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