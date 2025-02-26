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
@Table(name = "usuarios_dietas")
public class UsuarioDieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(length = 100)
    private String zona;

    @Column(length = 100)
    private String viatico;

    @Column(length = 100)
    private Double importe;

    @Column(name = "creado_en", updatable = false)
    private Timestamp creadoEn;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "actualizado_en")
    private Timestamp actualizadoEn;

    @Column(name = "actualizado_por")
    private Long actualizadoPor;

}