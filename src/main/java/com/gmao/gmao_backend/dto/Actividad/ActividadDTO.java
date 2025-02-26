package com.gmao.gmao_backend.dto.Actividad;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActividadDTO {
    private String codigo;
    private String nombre;
    private String categoria;
    private String protocolo;
    private String ubicacion;
    private Long creadoPor;
    private LocalDateTime creadoEn;
    private Long actualizadoPor;
    private LocalDateTime actualizadoEn;
    private Long eliminadoPor;
    private LocalDateTime eliminadoEn;
    private boolean estado;
    private boolean eliminado;
}
