package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_articuloDTO;
import com.gmao.gmao_backend.model.Alm_articulo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_articuloMapper {

    Alm_articuloDTO toDto(Alm_articulo alm_articulo);

    Alm_articulo toEntity(Alm_articuloDTO alm_articuloDTO);

    void updateFromDto(Alm_articuloDTO dto, @MappingTarget Alm_articulo entity);
}