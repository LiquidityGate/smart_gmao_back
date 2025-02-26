package com.gmao.gmao_backend.repository.AdministracionUsuarios.Configuracion;

import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosTablaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosVistaDTO;
import com.gmao.gmao_backend.model.UsuarioCargo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoCargosRepository
                extends JpaRepository<UsuarioCargo, Long>, JpaSpecificationExecutor<UsuarioCargo> {

        @Query("SELECT new com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosTablaDTO(cargo.id, cargo.nombre, cargo.descripcion, cargo.estado, cargo.creadoEn, CONCAT(usr.nombres,' ',usr.apellidos)) "
                        +
                        "FROM UsuarioCargo cargo " +
                        "LEFT JOIN Usuario usr ON usr.id = cargo.creadoPor " +
                        "WHERE cargo.eliminado = false " +
                        "AND (:#{#filtro.nombre} IS NULL OR cargo.nombre LIKE %:#{#filtro.nombre}%) ")
        Page<MantenimientoCargosTablaDTO> findTabla(
                        @Param("filtro") MantenimientoCargosTablaDTO filtro,
                        Pageable pageable);

        Optional<UsuarioCargo> findByNombre(String nombre);

        @Query("SELECT new com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosVistaDTO(cargo.id, cargo.nombre, cargo.descripcion, cargo.estado, cargo.creadoEn, CONCAT(usr.nombres,' ',usr.apellidos), cargo.actualizadoEn, CONCAT(usr2.nombres,' ',usr2.apellidos)) "
                        +
                        "FROM UsuarioCargo cargo " +
                        "LEFT JOIN Usuario usr ON usr.id = cargo.creadoPor " +
                        "LEFT JOIN Usuario usr2 ON usr2.id = cargo.actualizadoPor " +
                        "WHERE cargo.eliminado = false AND cargo.id = :idRegistro ")
        List<MantenimientoCargosVistaDTO> verRegistroPorID(@Param("idRegistro") Long idRegistro);

}