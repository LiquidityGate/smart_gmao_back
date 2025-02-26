package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.EstadosDTO;
import com.gmao.gmao_backend.model.Estados;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EstadosMapper {

    // Conversión de entidad a DTO
    @Mapping(source = "ingresado_por.id", target = "ingresado_porId")
    @Mapping(target = "ingresado_porNombre", expression = "java(estados.getIngresado_por().getNombres() + ' ' + estados.getIngresado_por().getApellidos())")
    EstadosDTO toDto(Estados estados);

    Estados toEntity(EstadosDTO estadosDTO);

    void updateFromDto(EstadosDTO dto, @MappingTarget Estados entity);
}