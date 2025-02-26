package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SalidaDTO;
import com.gmao.gmao_backend.model.Salida;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SalidaMapper {

    // Conversión de entidad a DTO
    //@Mapping(source = "solicitante.id", target = "solicitanteId")
    //@Mapping(target = "solicitanteNombre", expression = "java(salida.getSolicitante().getNombres() + ' ' + salida.getSolicitante().getApellidos())")
    SalidaDTO toDto(Salida salida);

    // Conversión de DTO a entidad
    Salida toEntity(SalidaDTO salidaDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(SalidaDTO dto, @MappingTarget Salida entity);
}