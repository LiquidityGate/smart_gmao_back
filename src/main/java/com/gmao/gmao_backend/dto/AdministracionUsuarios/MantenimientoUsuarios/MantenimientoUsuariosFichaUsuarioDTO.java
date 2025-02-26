package com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MantenimientoUsuariosFichaUsuarioDTO {

    private Long id;
    private String numIdentidad;

    private Long idIdentidad;
    private String nombreIdentidad;

    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;

    private Long idPerfil;
    private String nombrePerfil;

    private Long idSubtipo;
    private String nombreSubtipo;

    private Long idEmpresa;
    private String nombreEmpresa;

    private Boolean estado;

    private Long idCargo;
    private String nombreCargo;
    private Long idTurno;
    private String nombreTurno;

}