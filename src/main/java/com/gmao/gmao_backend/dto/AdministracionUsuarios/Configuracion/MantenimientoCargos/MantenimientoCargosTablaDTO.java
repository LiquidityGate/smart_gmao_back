package com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MantenimientoCargosTablaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Timestamp creadoEn;
    private String creadoPor;

}