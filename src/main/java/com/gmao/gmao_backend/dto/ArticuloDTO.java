package com.gmao.gmao_backend.dto;

//import java.sql.Date;

public class ArticuloDTO {

    private Long id;
    private String id_familias;
    private String id_subfamilia;
    private String nombre_art;
    private String id_marcas;
    private String coste_ultimo;
    private String stock_total;
    private String peso;
    private String largo;
    private String ancho;
    private String alto;
    private String nombre_imagen;
    private String estado;

    // Constructor vacío
    public ArticuloDTO() {
    }

    // Constructor con todos los campos
    public ArticuloDTO(Long id, String id_familias, String id_subfamilia, String nombre_art, String id_marcas,
            String coste_ultimo, String stock_total, String peso, String largo, String ancho, String alto,
            String nombre_imagen, String estado) {
        this.id = id;
        this.id_familias = id_familias;
        this.id_subfamilia = id_subfamilia;
        this.nombre_art = nombre_art;
        this.id_marcas = id_marcas;
        this.coste_ultimo = coste_ultimo;
        this.stock_total = stock_total;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.nombre_imagen = nombre_imagen;
        this.estado = estado;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_familias() {
        return id_familias;
    }

    public void setId_familias(String id_familias) {
        this.id_familias = id_familias;
    }

    public String getId_subfamilia() {
        return id_subfamilia;
    }

    public void setId_subfamilia(String id_subfamilia) {
        this.id_subfamilia = id_subfamilia;
    }

    public String getNombre_art() {
        return nombre_art;
    }

    public void setNombre_art(String nombre_art) {
        this.nombre_art = nombre_art;
    }

    public String getId_marcas() {
        return id_marcas;
    }

    public void setId_marcas(String id_marcas) {
        this.id_marcas = id_marcas;
    }

    public String getCoste_ultimo() {
        return coste_ultimo;
    }

    public void setCoste_ultimo(String coste_ultimo) {
        this.coste_ultimo = coste_ultimo;
    }

    public String getStock_total() {
        return stock_total;
    }

    public void setStock_total(String stock_total) {
        this.stock_total = stock_total;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getNombre_imagen() {
        return nombre_imagen;
    }

    public void setNombre_imagen(String nombre_imagen) {
        this.nombre_imagen = nombre_imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}