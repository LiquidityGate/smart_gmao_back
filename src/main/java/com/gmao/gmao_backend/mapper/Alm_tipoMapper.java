package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_tipoDTO;
import com.gmao.gmao_backend.model.Alm_tipo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_tipoMapper {

    Alm_tipoDTO toDto(Alm_tipo alm_tipo);

    Alm_tipo toEntity(Alm_tipoDTO alm_tipoDTO);

    void updateFromDto(Alm_tipoDTO dto, @MappingTarget Alm_tipo entity);
}