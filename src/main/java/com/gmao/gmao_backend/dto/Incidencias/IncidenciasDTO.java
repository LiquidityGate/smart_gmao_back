package com.gmao.gmao_backend.dto.Incidencias;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidenciasDTO {
        private String codigoItem;
        private String item;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaCierre;
        private String prioridad;
        private String estado;
        private int otOrigen;
        private int otGenerada;
        private String creadoPor;
        private LocalDateTime fechaCreado;
        private String modificadoPor;
        private LocalDateTime fechaModificado;
        private String eliminadoPor;
        private LocalDateTime fechaEliminado;
}

