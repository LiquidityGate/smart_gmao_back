package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_categoriaDTO;
import com.gmao.gmao_backend.model.Alm_categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_categoriaMapper {

    Alm_categoriaDTO toDto(Alm_categoria alm_categoria);

    Alm_categoria toEntity(Alm_categoriaDTO alm_categoriaDTO);

    void updateFromDto(Alm_categoriaDTO dto, @MappingTarget Alm_categoria entity);
}