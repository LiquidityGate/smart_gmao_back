package com.gmao.gmao_backend.dto.O.T;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdenesTrabajoDTO {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String tipo;
        private String periodo;
        private Integer ordenesFinalizadas;
        private BigDecimal horasRealesFinalizadas;
        private BigDecimal horasPrevistasFinalizadas;
        private Integer ordenesPendientes;
        private BigDecimal horasPrevistasPendientes;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String tipo;
        private String periodo;
        private Integer ordenesFinalizadas;
        private BigDecimal horasRealesFinalizadas;
        private BigDecimal horasPrevistasFinalizadas;
        private Integer ordenesPendientes;
        private BigDecimal horasPrevistasPendientes;
        private LocalDateTime fechaActualizacion;

        // Campos calculados
        private BigDecimal porcentajeCumplimiento;
        private BigDecimal desviacionHoras;
        private BigDecimal eficiencia;
        private BigDecimal tiempoMedioPorOrden;
        private BigDecimal totalHoras;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResumenDTO {
        private String tipo;
        private Integer totalOrdenesFinalizadas;
        private Integer totalOrdenesPendientes;
        private Integer totalOrdenes;
        private BigDecimal porcentajeAvance;
        private BigDecimal totalHorasReales;
        private BigDecimal totalHorasPrevistas;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TipoDTO {
        private String tipo;
        private String nombre;
        private String colorHeader;
    }
}