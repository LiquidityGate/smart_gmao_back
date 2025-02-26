package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.FamiliaDTO;
import com.gmao.gmao_backend.model.Familia;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FamiliaMapper {

    // Conversión de entidad a DTO
    //@Mapping(source = "solicitante.id", target = "solicitanteId")
    //@Mapping(target = "solicitanteNombre", expression = "java(familia.getSolicitante().getNombres() + ' ' + familia.getSolicitante().getApellidos())")
    FamiliaDTO toDto(Familia familia);

    // Conversión de DTO a entidad
    Familia toEntity(FamiliaDTO familiaDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(FamiliaDTO dto, @MappingTarget Familia entity);
}