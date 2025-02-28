package com.gmao.gmao_backend.mapper.O.T;

import com.gmao.gmao_backend.dto.O.T.OrdenTrabajoPreventivaLegalDTO;
import com.gmao.gmao_backend.model.O.T.OrdenTrabajoPreventivaLegal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdenTrabajoPreventivaLegalMapper {
    OrdenTrabajoPreventivaLegalMapper INSTANCE = Mappers.getMapper(OrdenTrabajoPreventivaLegalMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    OrdenTrabajoPreventivaLegal toEntity(OrdenTrabajoPreventivaLegalDTO.Request dto);

    @Mapping(target = "porcentajeCumplimiento", expression = "java(entity.getPorcentajeCumplimiento())")
    @Mapping(target = "desviacionHoras", expression = "java(entity.getDesviacionHoras())")
    @Mapping(target = "eficiencia", expression = "java(entity.getEficiencia())")
    @Mapping(target = "tiempoMedioPorOrden", expression = "java(entity.getTiempoMedioPorOrden())")
    @Mapping(target = "totalHoras", expression = "java(entity.getTotalHoras())")
    OrdenTrabajoPreventivaLegalDTO.Response toDto(OrdenTrabajoPreventivaLegal entity);

    List<OrdenTrabajoPreventivaLegalDTO.Response> toDtoList(List<OrdenTrabajoPreventivaLegal> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    void updateEntityFromDto(OrdenTrabajoPreventivaLegalDTO.Request dto, @MappingTarget OrdenTrabajoPreventivaLegal entity);
}
