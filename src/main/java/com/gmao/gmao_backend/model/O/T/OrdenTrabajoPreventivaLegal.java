package com.gmao.gmao_backend.model.O.T;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Entity
@Table(name = "g_ordenes_trabajo_preventivas_legal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenTrabajoPreventivaLegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Column(name = "ordenes_finalizadas")
    private Integer ordenesFinalizadas;

    @Column(name = "horas_reales_finalizadas", precision = 10 , scale = 2)
    private BigDecimal horasRealesFinalizadas;

    @Column(name = "horas_previstas_finalizadas", precision = 10, scale = 2)
    private BigDecimal horasPrevistasFinalizadas;

    @Column(name = "ordenes_pendientes")
    private Integer ordenesPendientes;

    @Column(name = "horas_previstas_pendientes", precision = 10, scale = 2)
    private BigDecimal horasPrevistasPendientes;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    // Métodos de cálculo para las observaciones mencionadas

    @Transient
    public BigDecimal getPorcentajeCumplimiento() {
        if (ordenesFinalizadas == null || ordenesPendientes == null) {
            return BigDecimal.ZERO;
        }

        Integer total = ordenesFinalizadas + ordenesPendientes;
        if (total == 0) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf(ordenesFinalizadas * 100.0 / total)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getDesviacionHoras() {
        if (horasRealesFinalizadas == null || horasPrevistasFinalizadas == null) {
            return BigDecimal.ZERO;
        }

        return horasRealesFinalizadas.subtract(horasPrevistasFinalizadas)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getEficiencia() {
        if (horasPrevistasFinalizadas == null || horasRealesFinalizadas == null
                || horasRealesFinalizadas.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return horasPrevistasFinalizadas.multiply(BigDecimal.valueOf(100))
                .divide(horasRealesFinalizadas, 2, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getTiempoMedioPorOrden() {
        if (horasRealesFinalizadas == null || ordenesFinalizadas == null
                || ordenesFinalizadas == 0) {
            return BigDecimal.ZERO;
        }

        return horasRealesFinalizadas.divide(BigDecimal.valueOf(ordenesFinalizadas), 2, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getTotalHoras() {
        BigDecimal totalFinalizadas = horasRealesFinalizadas != null ? horasRealesFinalizadas : BigDecimal.ZERO;
        BigDecimal totalPendientes = horasPrevistasPendientes != null ? horasPrevistasPendientes : BigDecimal.ZERO;

        return totalFinalizadas.add(totalPendientes)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @PrePersist
    @PreUpdate
    public void actualizarFecha() {
        fechaActualizacion = LocalDateTime.now();
    }
}
