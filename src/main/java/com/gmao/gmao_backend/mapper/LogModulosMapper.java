package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.LogModulosDTO;
import com.gmao.gmao_backend.model.LogModulos;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogModulosMapper {

        // Ficha Dieta
        LogModulos toEntity(LogModulosDTO dto);

}