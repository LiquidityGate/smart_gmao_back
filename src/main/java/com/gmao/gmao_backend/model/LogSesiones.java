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
@Table(name = "g_log_sesiones")
public class LogSesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inicio", updatable = false)
    private Timestamp fechaInicio;

    @Column(name = "fecha_cierre", updatable = false)
    private Timestamp fechaCierre;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "ip_address", length = 50)
    private String ipAddress;

    @Column(name = "user_agent", length = 512)
    private String userAgent;

    @Column(name = "token_jwt", length = 255)
    private String tokenJWT;

    @Column(name = "acceso")
    private Boolean acceso;

}