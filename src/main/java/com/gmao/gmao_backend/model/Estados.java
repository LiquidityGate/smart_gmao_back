package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Date;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "disp_estados")
public class Estados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String estado;
    private Date fecha;

    // Constructor con todos los campos
    public Estados(String nombre, String estado, AdministracionUsuarios ingresado_por, String ingresado_porNombre,
            Date fecha) {
        
        this.nombre = nombre;
        this.estado = estado;
        this.ingresado_por = ingresado_por;
        this.fecha = fecha;
    }

    // Constructor vacío
    public Estados() {}

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
