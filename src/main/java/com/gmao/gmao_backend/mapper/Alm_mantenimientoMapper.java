package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_mantenimientoDTO;
import com.gmao.gmao_backend.model.Alm_mantenimiento;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_mantenimientoMapper {

    Alm_mantenimientoDTO toDto(Alm_mantenimiento alm_mantenimiento);

    Alm_mantenimiento toEntity(Alm_mantenimientoDTO alm_mantenimientoDTO);

    void updateFromDto(Alm_mantenimientoDTO dto, @MappingTarget Alm_mantenimiento entity);
}