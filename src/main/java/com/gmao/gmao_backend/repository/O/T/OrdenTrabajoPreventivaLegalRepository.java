package com.gmao.gmao_backend.repository.O.T;

import com.gmao.gmao_backend.model.O.T.OrdenTrabajoPreventivaLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenTrabajoPreventivaLegalRepository extends JpaRepository<OrdenTrabajoPreventivaLegal, Long> {
    /**
     * Busca las órdenes de trabajo por periodo
     * @param periodo 'Mes actual' o 'Año actual'
     * @return Lista de órdenes que coinciden con el periodo
     */
    List<OrdenTrabajoPreventivaLegal> findByPeriodo(String periodo);

    /**
     * Busca una sola entrada por periodo (debe ser única)
     * @param periodo 'Mes actual' o 'Año actual'
     * @return Optional con la orden encontrada
     */
    Optional<OrdenTrabajoPreventivaLegal> findFirstByPeriodoOrderByFechaActualizacionDesc(String periodo);

    /**
     * Obtiene el número total de órdenes finalizadas
     * @return Suma de todas las órdenes finalizadas
     */
    @Query("SELECT COALESCE(SUM(o.ordenesFinalizadas), 0) FROM OrdenTrabajoPreventivaLegal o WHERE o.periodo = 'Año actual'")
    Integer getTotalOrdenesFinalizadasAnual();

    /**
     * Obtiene el número total de órdenes pendientes
     * @return Suma de todas las órdenes pendientes
     */
    @Query("SELECT COALESCE(SUM(o.ordenesPendientes), 0) FROM OrdenTrabajoPreventivaLegal o WHERE o.periodo = 'Año actual'")
    Integer getTotalOrdenesPendientesAnual();

    /**
     * Verifica si existe algún registro para un periodo específico
     * @param periodo 'Mes actual' o 'Año actual'
     * @return true si existe, false si no
     */
    boolean existsByPeriodo(String periodo);
}
