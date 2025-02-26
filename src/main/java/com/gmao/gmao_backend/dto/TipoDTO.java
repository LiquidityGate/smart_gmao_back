package com.gmao.gmao_backend.dto;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class TipoDTO {

    private Long id;
    private String nombre;
    private String estado;
    private Long ingresado_porId;
    private String ingresado_porNombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    // Constructor vacío
    public TipoDTO() {}

    // Constructor con todos los campos
    public TipoDTO(Long id, String nombre, String estado, Long ingresado_porId, String ingresado_porNombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
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