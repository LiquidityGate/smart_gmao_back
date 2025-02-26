package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_subtipoDTO;
import com.gmao.gmao_backend.model.Alm_subtipo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_subtipoMapper {

    Alm_subtipoDTO toDto(Alm_subtipo alm_subtipo);

    Alm_subtipo toEntity(Alm_subtipoDTO alm_subtipoDTO);

    void updateFromDto(Alm_subtipoDTO dto, @MappingTarget Alm_subtipo entity);
}