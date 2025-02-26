package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.IngresoDTO;
import com.gmao.gmao_backend.model.Ingreso;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IngresoMapper {

    // Conversión de entidad a DTO
    //@Mapping(source = "solicitante.id", target = "solicitanteId")
    //@Mapping(target = "solicitanteNombre", expression = "java(ingreso.getSolicitante().getNombres() + ' ' + ingreso.getSolicitante().getApellidos())")
    IngresoDTO toDto(Ingreso ingreso);

    // Conversión de DTO a entidad
    Ingreso toEntity(IngresoDTO ingresoDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(IngresoDTO dto, @MappingTarget Ingreso entity);
}