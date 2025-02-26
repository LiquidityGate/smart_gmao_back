package com.gmao.gmao_backend.dto;

public class Usu_feedbackDTO {

    private Long id;
    private Long id_usuario;
    private Long id_menu;
    private String archivo_img;
    private Long satisfaccion_ux;
    private Long navegacion_ux;
    private Long visual_ux;
    private Long informacion_ux;
    private String descripcion;
    private String fecha_crea;
    private String respuesta;
    private String fecha_rpt;
    private Long id_usu_rpt;
    private String estado_aten;
    private String fecha_cierre;
    private String estado;

    public Usu_feedbackDTO() {}

    public Usu_feedbackDTO(Long id, Long id_usuario, Long id_menu, String archivo_img, Long satisfaccion_ux, 
            Long navegacion_ux, Long visual_ux, Long informacion_ux, String descripcion, String fecha_crea, 
            String respuesta, String fecha_rpt, Long id_usu_rpt, String estado_aten, String fecha_cierre, 
            String estado) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_menu = id_menu;
        this.archivo_img = archivo_img;
        this.satisfaccion_ux = satisfaccion_ux;
        this.navegacion_ux = navegacion_ux;
        this.visual_ux = visual_ux;
        this.informacion_ux = informacion_ux;
        this.descripcion = descripcion;
        this.fecha_crea = fecha_crea;
        this.respuesta = respuesta;
        this.fecha_rpt = fecha_rpt;
        this.id_usu_rpt = id_usu_rpt;
        this.estado_aten = estado_aten;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_menu() {
        return id_menu;
    }

    public void setId_menu(Long id_menu) {
        this.id_menu = id_menu;
    }

    public String getArchivo_img() {
        return archivo_img;
    }

    public void setArchivo_img(String archivo_img) {
        this.archivo_img = archivo_img;
    }

    public Long getSatisfaccion_ux() {
        return satisfaccion_ux;
    }

    public void setSatisfaccion_ux(Long satisfaccion_ux) {
        this.satisfaccion_ux = satisfaccion_ux;
    }

    public Long getNavegacion_ux() {
        return navegacion_ux;
    }

    public void setNavegacion_ux(Long navegacion_ux) {
        this.navegacion_ux = navegacion_ux;
    }

    public Long getVisual_ux() {
        return visual_ux;
    }

    public void setVisual_ux(Long visual_ux) {
        this.visual_ux = visual_ux;
    }

    public Long getInformacion_ux() {
        return informacion_ux;
    }

    public void setInformacion_ux(Long informacion_ux) {
        this.informacion_ux = informacion_ux;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_crea() {
        return fecha_crea;
    }

    public void setFecha_crea(String fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFecha_rpt() {
        return fecha_rpt;
    }

    public void setFecha_rpt(String fecha_rpt) {
        this.fecha_rpt = fecha_rpt;
    }

    public Long getId_usu_rpt() {
        return id_usu_rpt;
    }

    public void setId_usu_rpt(Long id_usu_rpt) {
        this.id_usu_rpt = id_usu_rpt;
    }

    public String getEstado_aten() {
        return estado_aten;
    }

    public void setEstado_aten(String estado_aten) {
        this.estado_aten = estado_aten;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}