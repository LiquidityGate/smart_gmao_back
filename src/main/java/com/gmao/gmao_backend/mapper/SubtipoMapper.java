package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SubtipoDTO;
import com.gmao.gmao_backend.model.Subtipo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubtipoMapper {

    // Conversión de entidad a DTO
    @Mapping(source = "ingresado_por.id", target = "ingresado_porId")
    @Mapping(target = "ingresado_porNombre", expression = "java(subtipo.getIngresado_por().getNombres() + ' ' + subtipo.getIngresado_por().getApellidos())")
    SubtipoDTO toDto(Subtipo subtipo);

    Subtipo toEntity(SubtipoDTO subtipoDTO);

    void updateFromDto(SubtipoDTO dto, @MappingTarget Subtipo entity);
}