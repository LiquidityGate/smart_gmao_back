package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_turnoDTO;
import com.gmao.gmao_backend.model.Usu_turno;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_turnoMapper {

    Usu_turnoDTO toDto(Usu_turno usu_turno);

    Usu_turno toEntity(Usu_turnoDTO usu_turnoDTO);

    void updateFromDto(Usu_turnoDTO dto, @MappingTarget Usu_turno entity);
}