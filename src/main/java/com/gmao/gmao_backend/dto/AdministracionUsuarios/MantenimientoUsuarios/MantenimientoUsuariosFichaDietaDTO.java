package com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MantenimientoUsuariosFichaDietaDTO {

    private Long id;
    private Long idUsuario;
    private String zona;
    private String viatico;
    private Double importe;
    private Timestamp creadoEn;

}