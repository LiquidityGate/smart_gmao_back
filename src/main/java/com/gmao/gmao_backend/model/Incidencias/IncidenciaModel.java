package com.gmao.gmao_backend.model.Incidencias;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "g_incidencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private Long id;

    @Column(name = "codigo_item", nullable = false, length = 50)
    private String codigoItem;

    @Column(name = "item", nullable = false, length = 255)
    private String item;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;

    @Column(name = "prioridad", nullable = false, length = 50)
    private String prioridad;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "ot_origen", nullable = false)
    private int otOrigen;

    @Column(name = "ot_generada", nullable = false)
    private int otGenerada;

    @Column(name = "creado_por", nullable = false, length = 100)
    private String creadoPor;

    @Column(name = "fecha_creado", nullable = false, updatable = false)
    private LocalDateTime fechaCreado = LocalDateTime.now();

    @Column(name = "modificado_por", length = 100)
    private String modificadoPor;

    @Column(name = "fecha_modificado")
    private LocalDateTime fechaModificado;

    @Column(name = "eliminado_por", length = 100)
    private String eliminadoPor;

    @Column(name = "fecha_eliminado")
    private LocalDateTime fechaEliminado;
}

