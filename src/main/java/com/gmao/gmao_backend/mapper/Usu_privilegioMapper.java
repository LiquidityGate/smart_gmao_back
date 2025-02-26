package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_privilegioDTO;
import com.gmao.gmao_backend.model.Usu_privilegio;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_privilegioMapper {

    Usu_privilegioDTO toDto(Usu_privilegio usu_privilegio);

    Usu_privilegio toEntity(Usu_privilegioDTO usu_privilegioDTO);

    void updateFromDto(Usu_privilegioDTO dto, @MappingTarget Usu_privilegio entity);
}