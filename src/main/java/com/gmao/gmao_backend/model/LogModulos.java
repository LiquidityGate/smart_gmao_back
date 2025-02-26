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
@Table(name = "g_log_modulos")
public class LogModulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruta", length = 100)
    private String ruta;

    @Column(name = "id_menu")
    private Long idMenu;

    @Column(name = "creado_en", updatable = false)
    private Timestamp creadoEn;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "ip_address", length = 50)
    private String ipAddress;

    @Column(name = "user_agent", length = 512)
    private String userAgent;

    @Column(name = "acceso_menu")
    private Boolean accesoMenu;

    @Column(name = "token_jwt", length = 255)
    private String tokenJWT;

    @Column(name = "id_sesion")
    private Long idSesion;

}