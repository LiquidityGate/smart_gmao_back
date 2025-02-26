package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "g_alm_proveedores")
public class Alm_proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ruc;
    private String razon_social;
    private String nom_comercial;
    private String direccion;
    private String cod_postal;
    private String ciudad;
    private String provincia;
    private String pais;
    private String telefono;
    private String email;
    private String pagina_web;
    private String per_contacto;
    private String email_contacto;
    private String tlf_contacto;
    private String estado;

    public Alm_proveedor(){}

    // Constructor
    public Alm_proveedor(long id, String ruc, String razon_social, String nom_comercial, String direccion, 
                         String cod_postal, String ciudad, String provincia, String pais, String telefono, 
                         String email, String pagina_web, String per_contacto, String email_contacto, 
                         String tlf_contacto, String estado) {
        this.id = id;
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.nom_comercial = nom_comercial;
        this.direccion = direccion;
        this.cod_postal = cod_postal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
        this.pagina_web = pagina_web;
        this.per_contacto = per_contacto;
        this.email_contacto = email_contacto;
        this.tlf_contacto = tlf_contacto;
        this.estado = estado;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNom_comercial() {
        return nom_comercial;
    }

    public void setNom_comercial(String nom_comercial) {
        this.nom_comercial = nom_comercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getPer_contacto() {
        return per_contacto;
    }

    public void setPer_contacto(String per_contacto) {
        this.per_contacto = per_contacto;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }

    public String getTlf_contacto() {
        return tlf_contacto;
    }

    public void setTlf_contacto(String tlf_contacto) {
        this.tlf_contacto = tlf_contacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}