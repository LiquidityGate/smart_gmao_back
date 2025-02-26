package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Date;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "disp_dispositivos_subtipo")
public class Subtipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer nombre_tipo;
    private String nombre_subtipo;
    private String estado;
    private Date fecha;

    // Constructor con todos los campos
    public Subtipo(Integer nombre_tipo, String nombre_subtipo, String estado, AdministracionUsuarios ingresado_por, String ingresado_porNombre,
            Date fecha) {
        
        this.nombre_tipo = nombre_tipo;
        this.nombre_subtipo = nombre_subtipo;
        this.estado = estado;
        this.ingresado_por = ingresado_por;
        this.fecha = fecha;
    }

    // Constructor vacío
    public Subtipo() {}

    // Getters y Setters
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

    public void setNombre_tipo(String nombre_subtipo) {
        this.nombre_subtipo = nombre_subtipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingresado_por", referencedColumnName = "id") // Define la clave foránea para el usuario
                                                                     // solicitante
    private AdministracionUsuarios ingresado_por; // Referencia a la entidad UsuariosPortal

    public AdministracionUsuarios getIngresado_por() {
        return ingresado_por;
    }

    public void setIngresado_por(AdministracionUsuarios ingresado_por) {
        this.ingresado_por = ingresado_por;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
