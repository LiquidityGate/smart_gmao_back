package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_motivoDTO;
import com.gmao.gmao_backend.model.Alm_motivo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_motivoMapper {

    Alm_motivoDTO toDto(Alm_motivo alm_motivo);

    Alm_motivo toEntity(Alm_motivoDTO alm_motivoDTO);

    void updateFromDto(Alm_motivoDTO dto, @MappingTarget Alm_motivo entity);
}