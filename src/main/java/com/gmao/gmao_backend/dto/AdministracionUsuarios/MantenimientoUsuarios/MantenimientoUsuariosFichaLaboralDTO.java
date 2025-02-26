package com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MantenimientoUsuariosFichaLaboralDTO {

    private Long id;
    private Date fechaNacimiento;
    private String imei;
    private String equipo;
    private String carga;
    private String estadoPersonal;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoContrato;
    private Integer horasTrabajoAnuales;
    private Double salarioBase;
    private String aportacionSistema;
    private String turnoLaboral;
    private String foto;

}