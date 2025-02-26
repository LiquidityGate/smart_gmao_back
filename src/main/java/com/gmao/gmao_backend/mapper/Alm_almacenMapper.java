package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_almacenDTO;
import com.gmao.gmao_backend.model.Alm_almacen;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_almacenMapper {

    Alm_almacenDTO toDto(Alm_almacen alm_almacen);

    Alm_almacen toEntity(Alm_almacenDTO alm_almacenDTO);

    void updateFromDto(Alm_almacenDTO dto, @MappingTarget Alm_almacen entity);
}