package com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MantenimientoUsuariosTablaDTO {

    private Long id;
    private String nombres;
    private String apellidos;
    private String usuario;
    private Boolean estado;
    private String correo;
    private String telefono;
    private String numIdentidad;
    private Long idIdentidad;
    private Long idPerfil;
    private Long idSubtipo;
    private Long idEmpresa;
    private String valorIdentidad;
    private String valorPerfil;
    private String valorSubtipo;
    private String valorEmpresa;
    private String contraseña;
    private Long idCargo;
    private String valorCargo;
    private Long idTurno;
    private String valorTurno;
    private String trabajando;

}