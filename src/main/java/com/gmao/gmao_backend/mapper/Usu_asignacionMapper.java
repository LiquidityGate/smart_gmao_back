package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_asignacionDTO;
import com.gmao.gmao_backend.model.Usu_asignacion;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_asignacionMapper {

    Usu_asignacionDTO toDto(Usu_asignacion usu_asignacion);

    Usu_asignacion toEntity(Usu_asignacionDTO usu_asignacionDTO);

    void updateFromDto(Usu_asignacionDTO dto, @MappingTarget Usu_asignacion entity);
}