package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_logDTO;
import com.gmao.gmao_backend.model.Usu_log;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_logMapper {

    Usu_logDTO toDto(Usu_log usu_log);

    Usu_log toEntity(Usu_logDTO usu_logDTO);

    void updateFromDto(Usu_logDTO dto, @MappingTarget Usu_log entity);
}