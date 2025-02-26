package com.gmao.gmao_backend.dto;

public class Menu2DTO {

    private Long id;

    private String nombre;

    private Long menuPadre;

    private Long subMenuPadre;

    private String url;

    private Double orden;

    private String icono;

    private Boolean estado;

    // Constructor vacío
    public Menu2DTO() {
    }

    public Menu2DTO(Long id, String nombre, Long menuPadre, Long subMenuPadre, String url, Double orden, String icono,
            Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.menuPadre = menuPadre;
        this.subMenuPadre = subMenuPadre;
        this.url = url;
        this.orden = orden;
        this.icono = icono;
        this.estado = estado;
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

}