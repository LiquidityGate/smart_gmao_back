package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Immutable
@Entity
@Table(name = "vg_usu_log_detalles")
public class Usu_log_detalles {

    @Id
    private Long creado_por;
    private String ruta;
    private String creado_en;
    private String ip_address;
    private String user_agent;

    public Usu_log_detalles() {}

    public Usu_log_detalles(Long creado_por, String ruta, String creado_en, String ip_address, String user_agent) {
        this.creado_por = creado_por;
        this.ruta = ruta;
        this.creado_en = creado_en;
        this.ip_address = ip_address;
        this.user_agent = user_agent;
    }

    public Long getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(Long creado_por) {
        this.creado_por = creado_por;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }
}




