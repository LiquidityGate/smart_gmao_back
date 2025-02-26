package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

import org.hibernate.annotations.DynamicInsert;
import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicInsert
@Getter
@Setter
@Table(name = "g_usr_cargos")
public class UsuarioCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "estado", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean estado = true;

    @Column(name = "creado_en", updatable = false)
    private Timestamp creadoEn;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "actualizado_en")
    private Timestamp actualizadoEn;

    @Column(name = "actualizado_por")
    private Long actualizadoPor;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean eliminado = false;

}