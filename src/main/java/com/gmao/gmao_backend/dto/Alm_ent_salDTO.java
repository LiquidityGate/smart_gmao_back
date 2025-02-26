package com.gmao.gmao_backend.dto;

public class Alm_ent_salDTO {
    private Long id;
    private String articulo;
    private String cod_alm_padre;
    private String nom_alm_padre;
    private String proveedor;
    private String cant_entrada;
    private String precio_total;
    private String estado;

    public Alm_ent_salDTO(){}

    // Constructor
    public Alm_ent_salDTO(Long id, String articulo, String cod_alm_padre, String nom_alm_padre, String proveedor, String cant_entrada, String precio_total, String estado) {
        this.id = id;
        this.articulo = articulo;
        this.cod_alm_padre = cod_alm_padre;
        this.nom_alm_padre = nom_alm_padre;
        this.proveedor = proveedor;
        this.cant_entrada = cant_entrada;
        this.precio_total = precio_total;
        this.estado = estado;
    }

    // Getters and Setters
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCant_entrada() {
        return cant_entrada;
    }

    public void setCant_entrada(String cant_entrada) {
        this.cant_entrada = cant_entrada;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}