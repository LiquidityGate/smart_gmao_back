package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alm_motivos")
public class Alm_motivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String estado;

    public Alm_motivo() {}

    public Alm_motivo(String nombre, String estado) {
        this.nombre = nombre;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alm_motivo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}