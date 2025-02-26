package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "categorias")
public class Categorias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_padre")
    private Long idPadre;

    @Column(name = "nombre_padre")
    private String nombrePadre;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estado")
    private String estado;

    // Constructor vacío
    public Categorias() {
    }

    // Constructor con campos
    public Categorias(String nombre, Long idPadre, String nombrePadre, LocalDateTime fechaRegistro, String estado) {
        this.nombre = nombre;
        this.idPadre = idPadre;
        this.nombrePadre = nombrePadre;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
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

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idPadre=" + idPadre + '\'' +
                ", nombrePadre='" + nombrePadre + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}