package com.gmao.gmao_backend.model.Actividad;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "g_actinfra_activos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActividadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actinfra_activos")
    private Long id;

    @Column(name = "codigo", length = 100)
    private String codigo;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "protocolo", length = 100)
    private String protocolo;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    @Column(name = "actualizado_por")
    private Long actualizadoPor;

    @Column(name = "actualizado_en")
    private LocalDateTime actualizadoEn;

    @Column(name = "eliminado_por")
    private Long eliminadoPor;

    @Column(name = "eliminado_en")
    private LocalDateTime eliminadoEn;

    @Column(name = "estado")
    private boolean estado = true;

    @Column(name = "eliminado")
    private boolean eliminado = false;
}
