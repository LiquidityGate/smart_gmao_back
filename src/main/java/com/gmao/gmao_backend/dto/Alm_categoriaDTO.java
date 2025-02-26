package com.gmao.gmao_backend.dto;

public class Alm_categoriaDTO {

    private Long id;
    private String categoria;
    private String cat_padre;
    private String estado;

    public Alm_categoriaDTO() {}

    public Alm_categoriaDTO(Long id, String categoria, String cat_padre, String estado) {
        this.id = id;
        this.categoria = categoria;
        this.cat_padre = cat_padre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCat_padre() {
        return cat_padre;
    }

    public void setCat_padre(String cat_padre) {
        this.cat_padre = cat_padre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}