package com.gmao.gmao_backend.dto.MantenimientoPerfiles;

import java.util.List;

public class MantenimientoPerfilesMenusDTO {

    private Long id;
    private String nombre;
    private Long menuPadre;
    private Long subMenuPadre;
    private String url;
    private Double orden;
    private String icono;
    private Boolean estado;
    private Long idMenuAcceso;
    private List<MantenimientoPerfilesMenusDTO> subMenu;
    private Boolean crear;
    private Boolean ver;
    private Boolean editar;
    private Boolean eliminar;

    // Constructor vacío
    public MantenimientoPerfilesMenusDTO() {
    }

    public MantenimientoPerfilesMenusDTO(Long id, String nombre, Long menuPadre, Long subMenuPadre, String url,
            Double orden, String icono, Boolean estado, Long idMenuAcceso, List<MantenimientoPerfilesMenusDTO> subMenu,
            Boolean crear, Boolean ver, Boolean editar, Boolean eliminar) {
        this.id = id;
        this.nombre = nombre;
        this.menuPadre = menuPadre;
        this.subMenuPadre = subMenuPadre;
        this.url = url;
        this.orden = orden;
        this.icono = icono;
        this.estado = estado;
        this.idMenuAcceso = idMenuAcceso;
        this.subMenu = subMenu;
        this.crear = crear;
        this.ver = ver;
        this.editar = editar;
        this.eliminar = eliminar;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(Long menuPadre) {
        this.menuPadre = menuPadre;
    }

    public Long getSubMenuPadre() {
        return subMenuPadre;
    }

    public void setSubMenuPadre(Long subMenuPadre) {
        this.subMenuPadre = subMenuPadre;
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

    public Long getIdMenuAcceso() {
        return idMenuAcceso;
    }

    public void setIdMenuAcceso(Long idMenuAcceso) {
        this.idMenuAcceso = idMenuAcceso;
    }

    public List<MantenimientoPerfilesMenusDTO> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MantenimientoPerfilesMenusDTO> subMenu) {
        this.subMenu = subMenu;
    }

    public Boolean getCrear() {
        return crear;
    }

    public void setCrear(Boolean crear) {
        this.crear = crear;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }

}