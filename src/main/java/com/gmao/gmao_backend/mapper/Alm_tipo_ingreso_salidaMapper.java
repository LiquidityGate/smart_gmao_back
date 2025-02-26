package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_tipo_ingreso_salidaDTO;
import com.gmao.gmao_backend.model.Alm_tipo_ingreso_salida;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_tipo_ingreso_salidaMapper {

    Alm_tipo_ingreso_salidaDTO toDto(Alm_tipo_ingreso_salida alm_tipo_ingreso_salida);

    Alm_tipo_ingreso_salida toEntity(Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO);

    void updateFromDto(Alm_tipo_ingreso_salidaDTO dto, @MappingTarget Alm_tipo_ingreso_salida entity);
}