package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_condicion_pagoDTO;
import com.gmao.gmao_backend.model.Alm_condicion_pago;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_condicion_pagoMapper {

    Alm_condicion_pagoDTO toDto(Alm_condicion_pago alm_condicion_pago);

    Alm_condicion_pago toEntity(Alm_condicion_pagoDTO alm_condicion_pagoDTO);

    void updateFromDto(Alm_condicion_pagoDTO dto, @MappingTarget Alm_condicion_pago entity);
}