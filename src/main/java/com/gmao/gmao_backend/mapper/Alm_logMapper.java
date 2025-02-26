package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_logDTO;
import com.gmao.gmao_backend.model.Alm_log;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_logMapper {

    Alm_logDTO toDto(Alm_log alm_log);

    Alm_log toEntity(Alm_logDTO alm_logDTO);

    void updateFromDto(Alm_logDTO dto, @MappingTarget Alm_log entity);
}