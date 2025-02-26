package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionActividadGestionDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesMenusAccesosDTO;
import com.gmao.gmao_backend.model.AccesoXPerfil;
import com.gmao.gmao_backend.model.ActividadGestion;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MantenimientoPerfilesMapper {

    // Conversión de entidad a DTO
    MantenimientoPerfilesMenusAccesosDTO toDtoMenus(AccesoXPerfil usuario);

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    AccesoXPerfil toEntityMenus(MantenimientoPerfilesMenusAccesosDTO dto);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDto(MantenimientoPerfilesDTO dto, @MappingTarget UsuarioPerfil entity);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDtoAccesoXPerfil(MantenimientoPerfilesMenusAccesosDTO dto, @MappingTarget AccesoXPerfil entity);

    @Mapping(source = "creadoPor", target = "creadoPorId")
    @Mapping(source = "actualizadoPor", target = "actualizadoPorId")
    @Mapping(target = "actualizadoPorNombre", ignore = true)
    @Mapping(target = "creadoPorNombre", ignore = true)
    MantenimientoPerfilesDTO toDtoUsuarioPerfil(UsuarioPerfil entity);

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "estadoEliminado", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    UsuarioPerfil toEntityMantenimientoPerfilesDTO(MantenimientoPerfilesDTO dto);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDtoMantenimientoPerfilesDTO(MantenimientoPerfilesDTO dto, @MappingTarget UsuarioPerfil entity);
}