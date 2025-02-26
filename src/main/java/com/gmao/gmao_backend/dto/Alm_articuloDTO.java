package com.gmao.gmao_backend.dto;

public class Alm_articuloDTO {
    private Long id;
    private String nombre;
    private String proveedor;
    private String fabricante;
    private String marca;
    private String modelo;
    private String stock_minimo;
    private String stock_maximo;
    private String estado;

    public Alm_articuloDTO() {}

    // Constructor
    public Alm_articuloDTO(Long id, String nombre, String proveedor, String fabricante, String marca, String modelo, String stock_minimo, String stock_maximo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.fabricante = fabricante;
        this.marca = marca;
        this.modelo = modelo;
        this.stock_minimo = stock_minimo;
        this.stock_maximo = stock_maximo;
        this.estado = estado;
    }

    // Getters and Setters
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}