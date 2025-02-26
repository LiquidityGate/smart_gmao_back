package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_perfilDTO;
import com.gmao.gmao_backend.model.Usu_perfil;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_perfilMapper {

    Usu_perfilDTO toDto(Usu_perfil usu_perfil);

    Usu_perfil toEntity(Usu_perfilDTO usu_perfilDTO);

    void updateFromDto(Usu_perfilDTO dto, @MappingTarget Usu_perfil entity);
}