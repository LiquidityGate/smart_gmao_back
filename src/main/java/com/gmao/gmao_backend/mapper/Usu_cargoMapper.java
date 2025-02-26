package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_cargoDTO;
import com.gmao.gmao_backend.model.Usu_cargo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_cargoMapper {

    Usu_cargoDTO toDto(Usu_cargo usu_cargo);

    Usu_cargo toEntity(Usu_cargoDTO usu_cargoDTO);

    void updateFromDto(Usu_cargoDTO dto, @MappingTarget Usu_cargo entity);
}