package com.gmao.gmao_backend.dto;

//import java.sql.Date;

public class FamiliaDTO {

    private Long id;
    private String nombre;
    private Integer estado;

    // Constructor vacío
    public FamiliaDTO() {}

    // Constructor con todos los campos
    public FamiliaDTO(Long id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    // Getters y setters
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

}