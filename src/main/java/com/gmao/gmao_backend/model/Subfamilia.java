package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
//import java.sql.Date;

@Entity
@Table(name = "subfamilia")
public class Subfamilia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer estado;


    // Constructor vacío
    public Subfamilia() {}

    // Constructor con todos los campos
    public Subfamilia(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    

    @Override
    public String toString() {
        return "Subfamilia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}