// Archivo: AdministracionUsuariosReduced.java
package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_usuarios") // o el nombre real de tu tabla
public class AdministracionUsuariosIDName {

    @Id
    private Long id;

    private String nombres;
    private String apellidos;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}