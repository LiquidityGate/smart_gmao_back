package com.gmao.gmao_backend.dto;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class SubtipoDTO {

    private Long id;
    private Integer nombre_tipo;
    private String nombre_subtipo;
    private String estado;
    private Long ingresado_porId;
    private String ingresado_porNombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    // Constructor vacío
    public SubtipoDTO() {}

    // Constructor con todos los campos
    public SubtipoDTO(Long id, Integer nombre_tipo, String nombre_subtipo, String estado, Long ingresado_porId, String ingresado_porNombre, Date fecha) {
        this.id = id;
        this.nombre_tipo = nombre_tipo;
        this.nombre_subtipo = nombre_subtipo;
        this.estado = estado;
        this.ingresado_porId = ingresado_porId;
        this.ingresado_porNombre = ingresado_porNombre;
        this.fecha = fecha;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(Integer nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getNombre_subtipo() {
        return nombre_subtipo;
    }

    public void setNombre_subtipo(String nombre_subtipo) {
        this.nombre_subtipo = nombre_subtipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIngresado_porId() {
        return ingresado_porId;
    }

    public void setIngresado_porId(Long ingresado_porId) {
        this.ingresado_porId = ingresado_porId;
    }

    public String getIngresado_porNombre() {
        return ingresado_porNombre;
    }

    public void setIngresado_porNombre(String ingresado_porNombre) {
        this.ingresado_porNombre = ingresado_porNombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}