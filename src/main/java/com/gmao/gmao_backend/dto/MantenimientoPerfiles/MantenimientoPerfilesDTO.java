package com.gmao.gmao_backend.dto.MantenimientoPerfiles;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MantenimientoPerfilesDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Timestamp creadoEn;
    private Long creadoPorId;
    private String creadoPorNombre;
    private Timestamp actualizadoEn;
    private Long actualizadoPorId;
    private String actualizadoPorNombre;
    private Boolean estadoEliminado;

}