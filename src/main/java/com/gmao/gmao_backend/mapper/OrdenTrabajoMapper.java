package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.OrdenTrabajoDTO;
import com.gmao.gmao_backend.model.OrdenTrabajo;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrdenTrabajoMapper {

    @Mapping(source = "solicitante.id", target = "solicitanteId")
    @Mapping(target = "solicitanteNombre", expression = "java(ordenTrabajo.getSolicitante().getNombres() + ' ' + ordenTrabajo.getSolicitante().getApellidos())")
    OrdenTrabajoDTO toDto(OrdenTrabajo ordenTrabajo);

    // Conversión de DTO a entidad
    OrdenTrabajo toEntity(OrdenTrabajoDTO ordenTrabajoDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(OrdenTrabajoDTO dto, @MappingTarget OrdenTrabajo entity);
}