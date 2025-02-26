package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.TipoDTO;
import com.gmao.gmao_backend.model.Tipo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TipoMapper {

    // Conversión de entidad a DTO
    @Mapping(source = "ingresado_por.id", target = "ingresado_porId")
    @Mapping(target = "ingresado_porNombre", expression = "java(tipo.getIngresado_por().getNombres() + ' ' + tipo.getIngresado_por().getApellidos())")
    TipoDTO toDto(Tipo tipo);

    Tipo toEntity(TipoDTO tipoDTO);

    void updateFromDto(TipoDTO dto, @MappingTarget Tipo entity);
}