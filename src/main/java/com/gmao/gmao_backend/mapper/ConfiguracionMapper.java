package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionActividadGestionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionCargoDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTipoAsignacionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTurnoDTO;
import com.gmao.gmao_backend.model.ActividadGestion;
import com.gmao.gmao_backend.model.Cargo;
import com.gmao.gmao_backend.model.TipoAsignacion;
import com.gmao.gmao_backend.model.Turno;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConfiguracionMapper {

    // Cargo
    // Conversión de entidad a DTO
    @Mapping(source = "creadoPor", target = "creadoPorId")
    @Mapping(source = "actualizadoPor", target = "actualizadoPorId")
    @Mapping(target = "actualizadoPorNombre", ignore = true)
    @Mapping(target = "creadoPorNombre", ignore = true)
    ConfiguracionCargoDTO toDtoCargo(Cargo entity);

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "estadoEliminado", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    Cargo toEntityCargo(ConfiguracionCargoDTO dto);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDtoCargo(ConfiguracionCargoDTO dto, @MappingTarget Cargo entity);

    // ---------------------------------

    // Turno
    // Conversión de entidad a DTO
    @Mapping(source = "creadoPor", target = "creadoPorId")
    @Mapping(source = "actualizadoPor", target = "actualizadoPorId")
    @Mapping(target = "actualizadoPorNombre", ignore = true)
    @Mapping(target = "creadoPorNombre", ignore = true)
    ConfiguracionTurnoDTO toDtoTurno(Turno entity);

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "estadoEliminado", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    Turno toEntityTurno(ConfiguracionTurnoDTO dto);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDtoTurno(ConfiguracionTurnoDTO dto, @MappingTarget Turno entity);

    // ---------------------------------

    // Actividad de Gestion
    // Conversión de entidad a DTO
    @Mapping(source = "creadoPor", target = "creadoPorId")
    @Mapping(source = "actualizadoPor", target = "actualizadoPorId")
    @Mapping(target = "actualizadoPorNombre", ignore = true)
    @Mapping(target = "creadoPorNombre", ignore = true)
    ConfiguracionActividadGestionDTO toDtoActividadGestion(ActividadGestion entity);

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "estadoEliminado", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    ActividadGestion toEntityActividadGestion(ConfiguracionActividadGestionDTO dto);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDtoActividadGestion(ConfiguracionActividadGestionDTO dto, @MappingTarget ActividadGestion entity);

    // ---------------------------------

    // Tipo de Asignación
    // Conversión de entidad a DTO
    @Mapping(source = "creadoPor", target = "creadoPorId")
    @Mapping(source = "actualizadoPor", target = "actualizadoPorId")
    @Mapping(target = "actualizadoPorNombre", ignore = true)
    @Mapping(target = "creadoPorNombre", ignore = true)
    ConfiguracionTipoAsignacionDTO toDtoTipoAsignacion(TipoAsignacion entity);

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "estadoEliminado", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    TipoAsignacion toEntityTipoAsignacion(ConfiguracionTipoAsignacionDTO dto);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDtoTipoAsignacion(ConfiguracionTipoAsignacionDTO dto, @MappingTarget TipoAsignacion entity);

}