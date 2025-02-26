package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.OrdenCompraDTO;
import com.gmao.gmao_backend.model.OrdenCompra;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrdenCompraMapper {

    // Conversión de entidad a DTO
    //@Mapping(source = "solicitante.id", target = "solicitanteId")
    //@Mapping(target = "solicitanteNombre", expression = "java(ordenCompra.getSolicitante().getNombres() + ' ' + ordenCompra.getSolicitante().getApellidos())")
    OrdenCompraDTO toDto(OrdenCompra ordenCompra);

    // Conversión de DTO a entidad
    OrdenCompra toEntity(OrdenCompraDTO ordenCompraDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDto(OrdenCompraDTO dto, @MappingTarget OrdenCompra entity);
}