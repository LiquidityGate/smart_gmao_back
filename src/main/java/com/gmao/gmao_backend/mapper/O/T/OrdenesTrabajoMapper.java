package com.gmao.gmao_backend.mapper.O.T;

import com.gmao.gmao_backend.dto.O.T.OrdenesTrabajoDTO;
import com.gmao.gmao_backend.model.O.T.OrdenesTrabajo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdenesTrabajoMapper {

    OrdenesTrabajoMapper INSTANCE = Mappers.getMapper(OrdenesTrabajoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    OrdenesTrabajo toEntity(OrdenesTrabajoDTO.Request dto);

    @Mapping(target = "porcentajeCumplimiento", expression = "java(entity.getPorcentajeCumplimiento())")
    @Mapping(target = "desviacionHoras", expression = "java(entity.getDesviacionHoras())")
    @Mapping(target = "eficiencia", expression = "java(entity.getEficiencia())")
    @Mapping(target = "tiempoMedioPorOrden", expression = "java(entity.getTiempoMedioPorOrden())")
    @Mapping(target = "totalHoras", expression = "java(entity.getTotalHoras())")
    OrdenesTrabajoDTO.Response toDto(OrdenesTrabajo entity);

    List<OrdenesTrabajoDTO.Response> toDtoList(List<OrdenesTrabajo> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    void updateEntityFromDto(OrdenesTrabajoDTO.Request dto, @MappingTarget OrdenesTrabajo entity);
}
