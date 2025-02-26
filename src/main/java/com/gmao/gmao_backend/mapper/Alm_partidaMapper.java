package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_partidaDTO;
import com.gmao.gmao_backend.model.Alm_partida;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_partidaMapper {

    Alm_partidaDTO toDto(Alm_partida alm_partida);

    Alm_partida toEntity(Alm_partidaDTO alm_partidaDTO);

    void updateFromDto(Alm_partidaDTO dto, @MappingTarget Alm_partida entity);
}