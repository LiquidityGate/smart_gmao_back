package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.MarcasDTO;
import com.gmao.gmao_backend.model.Marcas;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MarcasMapper {

    // Conversión de entidad a DTO
    @Mapping(source = "ingresado_por.id", target = "ingresado_porId")
    @Mapping(target = "ingresado_porNombre", expression = "java(marcas.getIngresado_por().getNombres() + ' ' + marcas.getIngresado_por().getApellidos())")
    MarcasDTO toDto(Marcas marcas);

    Marcas toEntity(MarcasDTO marcasDTO);

    void updateFromDto(MarcasDTO dto, @MappingTarget Marcas entity);
}