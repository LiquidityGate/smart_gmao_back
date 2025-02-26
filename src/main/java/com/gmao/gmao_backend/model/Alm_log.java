package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "g_alm_logs")
public class Alm_log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String articulo;
    private String categoria;
    private String cod_almacen;
    private String nom_almacen;
    private String cantidad;
    private String precio;
    private String cod_proveedor;
    private String nom_proveedor;
    private String fecha;
    private String causa;

    public Alm_log() {}

    public Alm_log(Long id, String articulo, String categoria, String cod_almacen, String nom_almacen, String cantidad, String precio, String cod_proveedor, String nom_proveedor, String fecha, String causa) {
        this.id = id;
        this.articulo = articulo;
        this.categoria = categoria;
        this.cod_almacen = cod_almacen;
        this.nom_almacen = nom_almacen;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cod_proveedor = cod_proveedor;
        this.nom_proveedor = nom_proveedor;
        this.fecha = fecha;
        this.causa = causa;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCod_almacen() {
        return cod_almacen;
    }

    public void setCod_almacen(String cod_almacen) {
        this.cod_almacen = cod_almacen;
    }

    public String getNom_almacen() {
        return nom_almacen;
    }

    public void setNom_almacen(String nom_almacen) {
        this.nom_almacen = nom_almacen;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(String cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getNom_proveedor() {
        return nom_proveedor;
    }

    public void setNom_proveedor(String nom_proveedor) {
        this.nom_proveedor = nom_proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
    
}