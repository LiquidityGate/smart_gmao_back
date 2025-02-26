package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.CriticidadDTO;
import com.gmao.gmao_backend.model.Criticidad;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CriticidadMapper {

    // Conversión de entidad a DTO
    @Mapping(source = "ingresado_por.id", target = "ingresado_porId")
    @Mapping(target = "ingresado_porNombre", expression = "java(criticidad.getIngresado_por().getNombres() + ' ' + criticidad.getIngresado_por().getApellidos())")
    CriticidadDTO toDto(Criticidad criticidad);

    Criticidad toEntity(CriticidadDTO criticidadDTO);

    void updateFromDto(CriticidadDTO dto, @MappingTarget Criticidad entity);
}