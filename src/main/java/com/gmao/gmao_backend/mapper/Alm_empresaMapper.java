package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_empresaDTO;
import com.gmao.gmao_backend.model.Alm_empresa;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_empresaMapper {

    Alm_empresaDTO toDto(Alm_empresa alm_empresa);

    Alm_empresa toEntity(Alm_empresaDTO alm_empresaDTO);

    void updateFromDto(Alm_empresaDTO dto, @MappingTarget Alm_empresa entity);
}