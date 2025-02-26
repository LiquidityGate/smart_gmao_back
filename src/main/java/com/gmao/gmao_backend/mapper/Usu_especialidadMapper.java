package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_especialidadDTO;
import com.gmao.gmao_backend.model.Usu_especialidad;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_especialidadMapper {

    Usu_especialidadDTO toDto(Usu_especialidad usu_especialidad);

    Usu_especialidad toEntity(Usu_especialidadDTO usu_especialidadDTO);

    void updateFromDto(Usu_especialidadDTO dto, @MappingTarget Usu_especialidad entity);
}