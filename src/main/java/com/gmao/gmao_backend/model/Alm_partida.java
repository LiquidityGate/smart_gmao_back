package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "g_alm_partidas")
public class Alm_partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String ano;
    private String cod_item;
    private String item;
    private String n_cuenta;
    private String tipo_partida;
    private String capitulo;
    private String tipo_capitulo;
    private String importe;
    private String partida_pp;
    private String estado;


    Alm_partida(){}

    // Constructor
    public Alm_partida(Long id, String descripcion, String ano, String cod_item, String item, String n_cuenta, 
                       String tipo_partida, String capitulo, String tipo_capitulo, String importe, 
                       String partida_pp, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.ano = ano;
        this.cod_item = cod_item;
        this.item = item;
        this.n_cuenta = n_cuenta;
        this.tipo_partida = tipo_partida;
        this.capitulo = capitulo;
        this.tipo_capitulo = tipo_capitulo;
        this.importe = importe;
        this.partida_pp = partida_pp;
        this.estado = estado;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCod_item() {
        return cod_item;
    }

    public void setCod_item(String cod_item) {
        this.cod_item = cod_item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getN_cuenta() {
        return n_cuenta;
    }

    public void setN_cuenta(String n_cuenta) {
        this.n_cuenta = n_cuenta;
    }

    public String getTipo_partida() {
        return tipo_partida;
    }

    public void setTipo_partida(String tipo_partida) {
        this.tipo_partida = tipo_partida;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getTipo_capitulo() {
        return tipo_capitulo;
    }

    public void setTipo_capitulo(String tipo_capitulo) {
        this.tipo_capitulo = tipo_capitulo;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getPartida_pp() {
        return partida_pp;
    }

    public void setPartida_pp(String partida_pp) {
        this.partida_pp = partida_pp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}