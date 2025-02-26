package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SubfamiliaDTO;
import com.gmao.gmao_backend.model.Subfamilia;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubfamiliaMapper {

    // Conversión de entidad a DTO
    //@Mapping(source = "solicitante.id", target = "solicitanteId")
    //@Mapping(target = "solicitanteNombre", expression = "java(familia.getSolicitante().getNombres() + ' ' + familia.getSolicitante().getApellidos())")
    SubfamiliaDTO toDto(Subfamilia subfamilia);

    // Conversión de DTO a entidad
    Subfamilia toEntity(SubfamiliaDTO subfamiliaDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(SubfamiliaDTO dto, @MappingTarget Subfamilia entity);
}