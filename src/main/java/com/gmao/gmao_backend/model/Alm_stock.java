package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "g_alm_stocks")
public class Alm_stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String articulo;
    private String categoria;
    private String cod_alm_padre;
    private String nom_alm_padre;
    private String stock_minimo;
    private String stock_maximo;
    private String cantidad;

    public Alm_stock(){}

    // Constructor
    public Alm_stock(long id, String articulo, String categoria, String cod_alm_padre, 
                        String nom_alm_padre, String stock_minimo, String stock_maximo, 
                        String cantidad) {
        this.id = id;
        this.articulo = articulo;
        this.categoria = categoria;
        this.cod_alm_padre = cod_alm_padre;
        this.nom_alm_padre = nom_alm_padre;
        this.stock_minimo = stock_minimo;
        this.stock_maximo = stock_maximo;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCod_alm_padre() {
        return cod_alm_padre;
    }

    public void setCod_alm_padre(String cod_alm_padre) {
        this.cod_alm_padre = cod_alm_padre;
    }

    public String getNom_alm_padre() {
        return nom_alm_padre;
    }

    public void setNom_alm_padre(String nom_alm_padre) {
        this.nom_alm_padre = nom_alm_padre;
    }

    public String getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(String stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(String stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
}