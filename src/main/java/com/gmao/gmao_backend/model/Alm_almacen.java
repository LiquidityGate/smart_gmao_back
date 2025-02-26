package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "g_alm_almacenes")
public class Alm_almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cod_alm_padre;
    private String nom_alm_padre;
    private String ubicacion;
    private String estado;

    public Alm_almacen() {}

    public Alm_almacen(Long id, String nombre, String cod_alm_padre, String nom_alm_padre, String ubicacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.cod_alm_padre = cod_alm_padre;
        this.nom_alm_padre = nom_alm_padre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}