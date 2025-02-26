package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_stockDTO;
import com.gmao.gmao_backend.model.Alm_stock;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_stockMapper {

    Alm_stockDTO toDto(Alm_stock alm_stock);

    Alm_stock toEntity(Alm_stockDTO alm_stockDTO);

    void updateFromDto(Alm_stockDTO dto, @MappingTarget Alm_stock entity);
}