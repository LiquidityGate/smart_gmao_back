package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "disp_dispositivos")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int tipo;
    private int subtipo;
    private String codigo;
    private String nombre;
    private String numSerie;
    private int marca;
    private int criticidad;
    private int estado;
    private int plantilla;
    private int proveedor;
    private String imagen;
    private String video;
    private String complejo;
    private String edificio;
    private String planta;
    private String puntoKilometrico;
    private String latitud;
    private String longitud;
    private String sentidoVia;
    private String zonaVia;
    private String carril;
    private Integer subConjunto;
    private int condicion;
    private LocalDateTime ultVerificacion;
    private LocalDateTime fInstalacion;
    private LocalDateTime fAceptacion;
    private float precioCompra;
    private LocalDateTime fEliminacion;
    private String aniosVida;
    private LocalDateTime inicioAmortizacion;
    private LocalDateTime finAmortizacion;
    private String amortizacionAnual;
    private String totalmenteDepreciado;
    private LocalDateTime comienzoGarantia;
    private String contratoMantenimiento;
    private LocalDateTime finGarantia;
    private int factura;
    private float peso;
    private String nivelRuido;
    private String dimensiones;
    private String capacidad;
    private String vidaUtil;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(int subtipo) {
        this.subtipo = subtipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(int criticidad) {
        this.criticidad = criticidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(int plantilla) {
        this.plantilla = plantilla;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getComplejo() {
        return complejo;
    }

    public void setComplejo(String complejo) {
        this.complejo = complejo;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getPuntoKilometrico() {
        return puntoKilometrico;
    }

    public void setPuntoKilometrico(String puntoKilometrico) {
        this.puntoKilometrico = puntoKilometrico;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getSentidoVia() {
        return sentidoVia;
    }

    public void setSentidoVia(String sentidoVia) {
        this.sentidoVia = sentidoVia;
    }

    public String getZonaVia() {
        return zonaVia;
    }

    public void setZonaVia(String zonaVia) {
        this.zonaVia = zonaVia;
    }

    public String getCarril() {
        return carril;
    }

    public void setCarril(String carril) {
        this.carril = carril;
    }

    public int getSubConjunto() {
        return subConjunto;
    }

    public void setSubConjunto(int subConjunto) {
        this.subConjunto = subConjunto;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public LocalDateTime getUltVerificacion() {
        return ultVerificacion;
    }

    public void setUltVerificacion(LocalDateTime ultVerificacion) {
        this.ultVerificacion = ultVerificacion;
    }

    public LocalDateTime getFInstalacion() {
        return fInstalacion;
    }

    public void setFInstalacion(LocalDateTime fInstalacion) {
        this.fInstalacion = fInstalacion;
    }

    public LocalDateTime getFAceptacion() {
        return fAceptacion;
    }

    public void setFAceptacion(LocalDateTime fAceptacion) {
        this.fAceptacion = fAceptacion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public LocalDateTime getFEliminacion() {
        return fEliminacion;
    }

    public void setFEliminacion(LocalDateTime fEliminacion) {
        this.fEliminacion = fEliminacion;
    }

    public String getAniosVida() {
        return aniosVida;
    }

    public void setAniosVida(String aniosVida) {
        this.aniosVida = aniosVida;
    }

    public LocalDateTime getInicioAmortizacion() {
        return inicioAmortizacion;
    }

    public void setInicioAmortizacion(LocalDateTime inicioAmortizacion) {
        this.inicioAmortizacion = inicioAmortizacion;
    }

    public LocalDateTime getFinAmortizacion() {
        return finAmortizacion;
    }

    public void setFinAmortizacion(LocalDateTime finAmortizacion) {
        this.finAmortizacion = finAmortizacion;
    }

    public String getAmortizacionAnual() {
        return amortizacionAnual;
    }

    public void setAmortizacionAnual(String amortizacionAnual) {
        this.amortizacionAnual = amortizacionAnual;
    }

    public String getTotalmenteDepreciado() {
        return totalmenteDepreciado;
    }

    public void setTotalmenteDepreciado(String totalmenteDepreciado) {
        this.totalmenteDepreciado = totalmenteDepreciado;
    }

    public LocalDateTime getComienzoGarantia() {
        return comienzoGarantia;
    }

    public void setComienzoGarantia(LocalDateTime comienzoGarantia) {
        this.comienzoGarantia = comienzoGarantia;
    }

    public String getContratoMantenimiento() {
        return contratoMantenimiento;
    }

    public void setContratoMantenimiento(String contratoMantenimiento) {
        this.contratoMantenimiento = contratoMantenimiento;
    }

    public LocalDateTime getFinGarantia() {
        return finGarantia;
    }

    public void setFinGarantia(LocalDateTime finGarantia) {
        this.finGarantia = finGarantia;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNivelRuido() {
        return nivelRuido;
    }

    public void setNivelRuido(String nivelRuido) {
        this.nivelRuido = nivelRuido;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
    }
}
