package com.gmao.gmao_backend.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import org.hibernate.annotations.DynamicInsert;
import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicInsert
@Getter
@Setter
@Table(name = "tbl_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 255)
    private String usuario;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String contraseña;

    @Column(length = 255)
    private String remember_token;

    @Column(length = 100)
    private String nombres;

    @Column(length = 100)
    private String apellidos;

    @Column(name = "num_identidad", length = 20)
    private String numIdentidad;

    @Column(name = "id_identidad")
    private Long idIdentidad;

    @ManyToOne
    @JoinColumn(name = "id_identidad", insertable = false, updatable = false)
    private UsuarioTiposIdentidad tipoIdentidad;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false)
    private Boolean estado = true;

    @Column(name = "id_subtipo")
    private Long idSubtipo;

    @ManyToOne
    @JoinColumn(name = "id_subtipo", insertable = false, updatable = false)
    private UsuarioSubtipo subtipo;

    @Column(name = "id_perfil")
    private Long idPerfil;

    @ManyToOne
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private UsuarioPerfil perfil;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false)
    private Empresa empresa;

    @Column(name = "id_usuario_registro")
    private Long idUsuarioRegistro;

    @Column(name = "fecha_registro", updatable = false)
    private Timestamp fechaRegistro;

    @Column(name = "id_usuario_actualizacion")
    private Long idUsuarioActualizacion;

    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;

    @Column(name = "fecha_ult_conexion")
    private Timestamp fechaUltConexion;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "imei", length = 20)
    private String imei;

    @Column(name = "equipo", length = 50)
    private String equipo;

    @Column(name = "carga", length = 50)
    private String carga;

    @Column(name = "estado_personal", length = 50)
    private String estadoPersonal;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "tipo_contrato", length = 50)
    private String tipoContrato;

    @Column(name = "horas_trabajo_anuales")
    private Integer horasTrabajoAnuales;

    @Column(name = "salario_base")
    private Double salarioBase;

    @Column(name = "aportacion_sistema", length = 50)
    private String aportacionSistema;

    @Column(name = "turno_laboral", length = 50)
    private String turnoLaboral;

    @Column(name = "foto", length = 50)
    private String foto;

    @Column(name = "creado_en", updatable = false)
    private Timestamp creadoEn;

    @Column(name = "creado_por")
    private Long creadoPor;

    @Column(name = "actualizado_en")
    private Timestamp actualizadoEn;

    @Column(name = "actualizado_por")
    private Long actualizadoPor;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean eliminado = false;

    @Column(name = "id_cargo")
    private Long idCargo;

    @ManyToOne
    @JoinColumn(name = "id_cargo", insertable = false, updatable = false)
    private Usu_cargo cargo;

    @Column(name = "id_turno")
    private Long idTurno;

    @ManyToOne
    @JoinColumn(name = "id_turno", insertable = false, updatable = false)
    private Usu_turno turno;

    @Column(name = "trabajando", length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'si'")
    private String trabajando;

    @Column(name = "token_jwt", length = 255)
    private String tokenJWT;

}