package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ArticuloDTO;
import com.gmao.gmao_backend.model.Articulo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArticuloMapper {

    // Conversión de entidad a DTO
    //@Mapping(source = "solicitante.id", target = "solicitanteId")
    //@Mapping(target = "solicitanteNombre", expression = "java(articulo.getSolicitante().getNombres() + ' ' + articulo.getSolicitante().getApellidos())")
    ArticuloDTO toDto(Articulo articulo);

    // Conversión de DTO a entidad
    Articulo toEntity(ArticuloDTO articuloDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(ArticuloDTO dto, @MappingTarget Articulo entity);
}