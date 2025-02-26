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
public class MantenimientoCargosVistaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Timestamp creadoEn;
    private String creadoPor;
    private Timestamp actualizadoEn;
    private String actualizadoPor;

}