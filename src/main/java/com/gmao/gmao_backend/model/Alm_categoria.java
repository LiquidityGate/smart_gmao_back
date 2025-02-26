package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "g_alm_categorias")
public class Alm_categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String cat_padre;
    private String estado;

    public Alm_categoria() {}

    public Alm_categoria(Long id, String categoria, String cat_padre, String estado) {
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