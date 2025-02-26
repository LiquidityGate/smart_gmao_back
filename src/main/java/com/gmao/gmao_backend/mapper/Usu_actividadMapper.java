package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_actividadDTO;
import com.gmao.gmao_backend.model.Usu_actividad;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_actividadMapper {

    Usu_actividadDTO toDto(Usu_actividad usu_actividad);

    Usu_actividad toEntity(Usu_actividadDTO usu_actividadDTO);

    void updateFromDto(Usu_actividadDTO dto, @MappingTarget Usu_actividad entity);
}