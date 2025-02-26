package com.gmao.gmao_backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tbl_menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "menu_padre")
    private Long menuPadre;

    @Column(name = "sub_menu_padre")
    private Long subMenuPadre;

    @OneToMany(mappedBy = "menuPadre")
    @OrderBy("orden ASC")
    private List<Menu> subMenu;

    @Column(name = "url", length = 100)
    private String url;

    @Column(name = "orden")
    private Double orden;

    @Column(name = "icono", length = 100)
    private String icono;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "creado_en", updatable = false)
    private Timestamp creadoEn;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "actualizado_en")
    private Timestamp actualizadoEn;

    @Column(name = "actualizado_por")
    private Long actualizadoPor;

    @Column(name = "ingles", length = 100)
    private String ingles;

    @Column(name = "aleman", length = 100)
    private String aleman;

    @Column(name = "italiano", length = 100)
    private String italiano;

    @Column(name = "ruso", length = 100)
    private String ruso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(Long menuPadre) {
        this.menuPadre = menuPadre;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getOrden() {
        return orden;
    }

    public void setOrden(Double orden) {
        this.orden = orden;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Timestamp getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Timestamp creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Timestamp getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(Timestamp actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public Long getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(Long actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getAleman() {
        return aleman;
    }

    public void setAleman(String aleman) {
        this.aleman = aleman;
    }

    public String getItaliano() {
        return italiano;
    }

    public void setItaliano(String italiano) {
        this.italiano = italiano;
    }

    public String getRuso() {
        return ruso;
    }

    public void setRuso(String ruso) {
        this.ruso = ruso;
    }

    public Long getSubMenuPadre() {
        return subMenuPadre;
    }

    public void setSubMenuPadre(Long subMenuPadre) {
        this.subMenuPadre = subMenuPadre;
    }

}