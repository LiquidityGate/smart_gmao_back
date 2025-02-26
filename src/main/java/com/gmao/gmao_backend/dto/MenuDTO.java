package com.gmao.gmao_backend.dto;

import java.util.List;

public class MenuDTO {

    private Long id;
    private String nombre;
    private String url;
    private Double orden;
    private Boolean estado;
    private String icono;
    private Long menuPadre;
    private Long subMenuPadre;
    private List<MenuDTO> subMenu;
    private String ingles;
    private String aleman;
    private String italiano;
    private String ruso;

    // Constructor vacío
    public MenuDTO() {
    }

    public MenuDTO(Long id, String nombre, String url, Double orden, Boolean estado, String icono, Long menuPadre,
            Long subMenuPadre,
            List<MenuDTO> subMenu, String ingles, String aleman, String italiano,
            String ruso) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.orden = orden;
        this.estado = estado;
        this.icono = icono;
        this.menuPadre = menuPadre;
        this.subMenuPadre = subMenuPadre;
        this.subMenu = subMenu;
        this.ingles = ingles;
        this.aleman = aleman;
        this.italiano = italiano;
        this.ruso = ruso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getSubMenuPadre() {
        return subMenuPadre;
    }

    public void setSubMenuPadre(Long subMenuPadre) {
        this.subMenuPadre = subMenuPadre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Long getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(Long menuPadre) {
        this.menuPadre = menuPadre;
    }

    public List<MenuDTO> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuDTO> subMenu) {
        this.subMenu = subMenu;
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

}